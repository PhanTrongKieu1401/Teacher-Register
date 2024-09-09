package com.example.Teacher.controller;

import com.example.Teacher.controller.PickedSectionClassController;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@WebMvcTest(PickedSectionClass.class)
public class PickedSectionClassControllerTest {

    @Mock
    private pickedSectionClassService pickedSectionClassService;

    @Mock
    private teacherService teacherService;

    @Mock
    private staffService staffService;

    @Mock
    private subjectService subjectService;

    @InjectMocks
    private PickedSectionClassController controller;

    @Mock
    private HttpSession session;

    @Mock
    private ModelMap modelMap;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testReturnHome() {
        Member member = new Member();
        member.setId(1);

        Staff staff = new Staff();
        staff.setIdMenber(1);

        Teacher teacher = new Teacher();
        teacher.setDepartment(new Department());

        List<Subject> subjectList = new ArrayList<>();
        List<PickedSectionClass> pickedSectionClasses = new ArrayList<>();

        when(session.getAttribute("member")).thenReturn(member);
        when(staffService.findStaff(anyInt())).thenReturn(staff);
        when(teacherService.findTeacher(anyInt())).thenReturn(teacher);
        when(subjectService.getAll(anyInt())).thenReturn(subjectList);
        when(pickedSectionClassService.getAllByIdDepartment(anyInt())).thenReturn(pickedSectionClasses);

        String result = controller.returnHome(session, modelMap);

        assertEquals("register_schedule", result);
        verify(session).setAttribute("teacher", teacher);
        verify(modelMap).addAttribute("listSubject", subjectList);
        verify(modelMap).addAttribute("listPicked", pickedSectionClasses);
        verify(session).removeAttribute("error1");
    }

    @Test
    public void testDeletePicked_PickedSectionClassReviewIsOne() {
        Integer id = 1;
        PickedSectionClass pickedSectionClass = new PickedSectionClass();
        pickedSectionClass.setReview(1);

        when(pickedSectionClassService.findById(id)).thenReturn(pickedSectionClass);

        String result = controller.deletePicked(id, modelMap, session);

        assertEquals("redirect:/home1", result);
        verify(session).setAttribute("error1", "Học phần đã được phê duyệt , Không thể xóa");
        verify(pickedSectionClassService, never()).deleteById(id);
    }

    @Test
    public void testDeletePicked_PickedSectionClassReviewIsNotOne() {
        Integer id = 1;
        PickedSectionClass pickedSectionClass = new PickedSectionClass();
        pickedSectionClass.setReview(0);

        when(pickedSectionClassService.findById(id)).thenReturn(pickedSectionClass);

        String result = controller.deletePicked(id, modelMap, session);

        assertEquals("redirect:/home1", result);
        verify(pickedSectionClassService).deleteById(id);
    }


    @Test
    public void testSaveListPickedSectionClass_Success() {

        ModelMap modelMap1 = Mockito.mock(ModelMap.class);
        HttpSession session1 = Mockito.mock(HttpSession.class);
        // Arrange
        String idPickedsString = "1,2,3"; // Example list of IDs
        List<Integer> idPickeds = Arrays.asList(1, 2, 3);
        List<Subject> subjectList = new ArrayList<>();
        List<PickedSectionClass> pickedSectionClassList = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        Department department = new Department();
        department.setId(3);
        teacher.setDepartment(department);
        when(pickedSectionClassService.findById(anyInt())).thenReturn(new PickedSectionClass());
        when(modelMap.addAttribute(anyString(), any())).thenReturn(modelMap);
        when(session.getAttribute("member")).thenReturn(new Member());
        when(staffService.findStaff(anyInt())).thenReturn(new Staff());
        when(teacherService.findTeacher(anyInt())).thenReturn(teacher);
        when(subjectService.getAll(teacher.getDepartment().getId())).thenReturn(subjectList);
        when(pickedSectionClassService.getAllByIdDepartment(anyInt())).thenReturn(new ArrayList<>());
        when(session.getAttribute("teacherList")).thenReturn(new ArrayList<>());

        // Act
        String viewName = controller.SaveListPickedSectionClass(idPickedsString, modelMap, session);

        // Assert
        assertEquals("review", viewName);
        verify(modelMap).addAttribute("listSubject", subjectList);
        verify(modelMap).addAttribute("listPicked", pickedSectionClassList);
        verify(modelMap).addAttribute("teacherList", teacherList);
        verify(pickedSectionClassService, times(3)).findById(anyInt());
        verify(pickedSectionClassService, times(3)).save(any(PickedSectionClass.class));
    }

}
