package com.example.Teacher.controller;

import com.example.Teacher.entities.*;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.Teacher.service.*;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyList;

@WebMvcTest(MemberController.class)
public class MemberControllerTest {
    @MockBean
    private memberService memberService;

    @MockBean
    private teacherService teacherService;

    @MockBean
    private staffService staffService;

    @MockBean
    private pickedSectionClassService pickedSectionClassService;

    @MockBean
    private subjectService subjectService;

    @Autowired
    private MemberController memberController;

    @Test
    public void testCheckLogin_validCredentials_redirectsToApproveSchedule() throws Exception {
        String username = "trinhnc";
        String password = "trinhnc";
        Member member = new Member();
        Staff staff = new Staff();
        staff.setIdMenber(1);
        Teacher teacher = new Teacher();
        teacher.setPosittion(1);
        teacher.setDepartment(new Department());
        member.setStaff(staff);
        when(memberService.checkLogin(username, password)).thenReturn(member);
        when(staffService.findStaff(member.getId())).thenReturn(staff);
        when(teacherService.findTeacher(staff.getIdMenber())).thenReturn(teacher);

        HttpSession session = Mockito.mock(HttpSession.class);
        ModelMap modelMap = Mockito.mock(ModelMap.class);

        String viewName = memberController.checkLogin(session, modelMap, username, password);
        assertEquals("approve_schedule", viewName);
        verify(session).setAttribute("member", member);
        verify(modelMap).addAttribute("listSubject", teacher.getDepartment().getSubjects());
    }

    @Test
    public void testCheckLogin_validCredentials_redirectsToRegisterSchedule() throws Exception {
        String username = "trinhnc";
        String password = "trinhnc";
        Member member = new Member();
        Staff staff = new Staff();
        staff.setIdMenber(1);
        Teacher teacher = new Teacher();
        teacher.setPosittion(0);
        teacher.setDepartment(new Department());
        member.setStaff(staff);
        when(memberService.checkLogin(username, password)).thenReturn(member);
        when(staffService.findStaff(member.getId())).thenReturn(staff);
        when(teacherService.findTeacher(staff.getIdMenber())).thenReturn(teacher);
        HttpSession session = Mockito.mock(HttpSession.class);
        ModelMap modelMap = Mockito.mock(ModelMap.class);

        String viewName = memberController.checkLogin(session, modelMap, username, password);
        assertEquals("register_schedule", viewName);
        verify(session).setAttribute("member", member);
        verify(modelMap).addAttribute("listSubject", teacher.getDepartment().getSubjects());
        verify(modelMap).addAttribute("listPicked", teacher.getPickedSectionClasses());
    }

    @Test
    public void testCheckLogin_invalidCredentials_redirectsToLoginPage() throws Exception {
        String username = "trinhnc";
        String password = "trinhnc1";
        when(memberService.checkLogin(username, password)).thenReturn(null);
        HttpSession session = Mockito.mock(HttpSession.class);
        ModelMap modelMap = Mockito.mock(ModelMap.class);

        String viewName = memberController.checkLogin(session, modelMap, username, password);
        assertEquals("login-form", viewName);
        verify(modelMap).addAttribute("error", "Tai khoan mat khau khong chinh xac");
    }

}