package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class MemberController {
    @Autowired
    private memberService memberService;
    @Autowired
    private teacherService teacherService;
    @Autowired
    private staffService staffService;
    @Autowired
    private pickedSectionClassService pickedSectionClassService;
    @Autowired
    private subjectService subjectService;

    @GetMapping("/login")
    public String login() {
        return "login-form";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("member");
        return "redirect:/login";
    }

    @RequestMapping("/home")
    public String checkLogin(HttpSession session, ModelMap modelMap, @RequestParam(name = "username") String username,
                             @RequestParam(name = "password") String password) {
        Member member =  memberService.checkLogin(username, password);
        if (member != null) {
            session.setAttribute("member", member);

            Staff staff  = staffService.findStaff(member.getId());
            Teacher teacher = teacherService.findTeacher(staff.getIdMenber());
            session.setAttribute("teacher", teacher);

            List<Subject> subjectList = teacher.getDepartment().getSubjects();
            modelMap.addAttribute("listSubject", subjectList);


            if (teacher.getPosittion() == 1) {
                Department department = teacher.getDepartment();
                modelMap.addAttribute("teacherList", department.getTeachers());
                List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(teacher.getDepartment().getId());
                session.setAttribute("listPicked", pickedSectionClasses);
                session.setAttribute("teacherList", department.getTeachers());
                session.setAttribute("listSubject", subjectList);

                modelMap.addAttribute("listPicked", pickedSectionClasses);

                return "approve_schedule";
            } else {
                List<PickedSectionClass> pickedSectionClasses = teacher.getPickedSectionClasses();
                modelMap.addAttribute("listPicked", pickedSectionClasses);

                return "register_schedule";
            }
        } else {
            modelMap.addAttribute("error", "Tai khoan mat khau khong chinh xac");
            return "login-form";
        }
    }


    @GetMapping("/home2")
    public String redirect(HttpSession session, ModelMap modelMap) {

        Member member = (Member) session.getAttribute("member");

        Staff staff  = staffService.findStaff(member.getId());
        Teacher teacher = teacherService.findTeacher(staff.getIdMenber());

        List<Subject> subjectList = teacher.getDepartment().getSubjects();
        modelMap.addAttribute("listSubject", subjectList);


        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(teacher.getDepartment().getId());
        modelMap.addAttribute("listPicked", pickedSectionClasses);

        Department department = teacher.getDepartment();
        modelMap.addAttribute("teacherList", department.getTeachers());
        session.setAttribute("teacherList", department.getTeachers());
        session.setAttribute("listSubject", subjectList);

        session.setAttribute("listPicked", pickedSectionClasses);
        String s = (String) session.getAttribute("error2");
        session.removeAttribute("error2");
        modelMap.addAttribute("error2", s);

        return "approve_schedule";
    }
}
