package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.Teacher.service.*;
import com.example.Teacher.entities.*;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@WebMvcTest(ScheduleController.class)
public class ScheduleControllerTest {
    @MockBean
    pickedSectionClassService pickedSectionClassService;
    @MockBean
    scheduleService scheduleService;
    @MockBean
    teacherService teacherService;
    @MockBean
    private HttpSession session;
    @MockBean
    private ModelMap modelMap;
    @MockBean
    private Member member;
    @MockBean
    private Teacher teacher;
    @MockBean
    private Subject subject;
    @Autowired
    private ScheduleController yourController;
    @InjectMocks
    private ScheduleController scheduleController;
    @Test
    public void testGetListPickedSectionClassByIdTeacher() {
        List<PickedSectionClass> list = new ArrayList<>();

        when(pickedSectionClassService.getAllbyId(3)).thenReturn(list);

        List<PickedSectionClass> result = yourController.GetListPickedSectionClassByIdTeacher(3);
        assertEquals(list, result);
    }
    @Test
    public void testGetListSectionClassByListPickedSectionClass() {
        // Tạo mock objects cho PickedSectionClass và SectionClass
        PickedSectionClass pickedSectionClass1 = Mockito.mock(PickedSectionClass.class);
        PickedSectionClass pickedSectionClass2 = Mockito.mock(PickedSectionClass.class);

        SectionClass sectionClass1 = Mockito.mock(SectionClass.class);
        SectionClass sectionClass2 = Mockito.mock(SectionClass.class);

        // Cấu hình behavior cho mocked objects
        when(pickedSectionClass1.getSectionClass()).thenReturn(sectionClass1);
        when(pickedSectionClass2.getSectionClass()).thenReturn(sectionClass2);

        // Tạo danh sách giả định
        List<PickedSectionClass> list = new ArrayList<>();
        list.add(pickedSectionClass1);
        list.add(pickedSectionClass2);

        // Gọi phương thức cần kiểm tra từ controller
        ScheduleController controller = new ScheduleController();
        List<SectionClass> result = controller.getListSectionClassByListPickedSectionClass(list);

        // Kiểm tra kết quả trả về từ controller
        assertEquals(2, result.size());
        assertEquals(sectionClass1, result.get(0));
        assertEquals(sectionClass2, result.get(1));
    }
    @Test
    public void testGetAllListScheduleByListSectionClass() {
        // Tạo mock objects cho SectionClass và ScheduleService
        SectionClass sectionClass1 = Mockito.mock(SectionClass.class);
        SectionClass sectionClass2 = Mockito.mock(SectionClass.class);


        // Tạo danh sách giả định cho sectionClassList
        List<SectionClass> sectionClassList = new ArrayList<>();
        sectionClassList.add(sectionClass1);
        sectionClassList.add(sectionClass2);

        // Tạo danh sách giả định cho kết quả từ scheduleService
        List<Schedule> scheduleList1 = new ArrayList<>();
        scheduleList1.add(new Schedule());

        List<Schedule> scheduleList2 = new ArrayList<>();
        scheduleList2.add(new Schedule());

        // Cấu hình behavior cho scheduleService
        when(scheduleService.getScheduleByIdSectionClass(sectionClass1.getId())).thenReturn(scheduleList1);
        when(scheduleService.getScheduleByIdSectionClass(sectionClass2.getId())).thenReturn(scheduleList2);

        // Gọi phương thức cần kiểm tra từ controller
        List<Schedule> result = yourController.getALlListScheduleByListSectionClass(sectionClassList);

        // Kiểm tra kết quả trả về từ controller
        assertEquals(2, result.size());
        // Kiểm tra xem danh sách kết quả có chứa các Schedule như mong đợi không
        assertTrue(result.contains(scheduleList1.get(0)));
        assertTrue(result.contains(scheduleList2.get(0)));
    }
    @Test
    public void testGetScheduleByIdSectionClass() {

        // Tạo danh sách giả định cho kết quả từ scheduleService
        List<Schedule> scheduleList = new ArrayList<>();
        scheduleList.add(new Schedule(/* Thêm thông tin về Schedule ở đây */));

        // Cấu hình behavior cho scheduleService
        when(scheduleService.getScheduleByIdSectionClass(anyInt())).thenReturn(scheduleList);

        // Gọi phương thức cần kiểm tra từ ScheduleService
        List<Schedule> results = scheduleService.getScheduleByIdSectionClass(1);
        Schedule result = results.get(0);

        // Kiểm tra kết quả trả về từ ScheduleService
        assertNotNull(result);
        // Kiểm tra xem kết quả có là một đối tượng Schedule không
        assertTrue(result instanceof Schedule);
    }
//    @Test
//    public void testConvertListScheduleToString() {
//        // Tạo đối tượng mock cho các phương thức phụ thuộc
//        List<PickedSectionClass> pickedSectionClassList = new ArrayList<>();
//        List<SectionClass> sectionClassList = new ArrayList<>();
//        List<Schedule> scheduleList = new ArrayList<>();
//        // Giả định behavior của các phương thức phụ thuộc
//        when(scheduleController.GetListPickedSectionClassByIdTeacher(anyInt())).thenReturn(pickedSectionClassList);
//        when(scheduleController.getListSectionClassByListPickedSectionClass(pickedSectionClassList)).thenReturn(sectionClassList);
//        when(scheduleController.getALlListScheduleByListSectionClass(sectionClassList)).thenReturn(scheduleList);
//        // Khởi tạo đối tượng ScheduleController
//        ScheduleController controller = new ScheduleController();
//        // Gọi phương thức cần kiểm tra
//        List<String> result = controller.ConvertListScheduleToString(1);
//        // Kiểm tra kết quả
//        assertEquals(0, result.size());
//    }

//
//    @Test
//    public void testGetAllScheduleByIdSos() {
//        // Initialize mocks
//        MockitoAnnotations.initMocks(this);
//
//        // Setup session attributes
//        Member member = new Member();
//        member.setId(1);
//        Subject subject = new Subject();
//        subject.setId(1);
//        when(session.getAttribute("member")).thenReturn(member);
//        when(session.getAttribute("subject")).thenReturn(subject);
//
//        // Setup mock responses
//        Teacher teacher = new Teacher();
//        teacher.setId(1);
//        Schedule schedule = new Schedule();
//        day day = new day();
//        day.setId(1);
//        day.setName("Thu 2");
//        schedule.setDay(day);
//
//        when(teacherService.findTeacher(anyInt())).thenReturn(teacher);
//        when(scheduleService.findById(anyInt())).thenReturn(new Schedule());
//        // Call the method
//        String result = scheduleController.getAllScheduleByIdSos(3, session, modelMap);
//
//        // Verify interactions
//        verify(session, times(1)).getAttribute("member");
//        verify(session, times(1)).getAttribute("subject");
//        verify(session, times(1)).removeAttribute("subject");
//        verify(modelMap, times(1)).addAttribute(eq("listPicked"), anyList());
//        verify(scheduleService, times(1)).findById(anyInt());
//        verify(pickedSectionClassService, times(1)).getAllbyId(anyInt());
//
//        // Assert the result
//        // Assuming that the method returns a redirect string
//        // You may need to adjust the assertion based on the actual return value of the method
//        assertEquals("redirect:/subject/1", result);
//    }
//
}
