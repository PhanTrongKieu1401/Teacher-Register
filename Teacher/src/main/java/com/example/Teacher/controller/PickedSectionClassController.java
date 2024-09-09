package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;

import java.security.PublicKey;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("")
public class PickedSectionClassController {
    @Autowired
    pickedSectionClassService pickedSectionClassService;
    @Autowired
    private teacherService teacherService;
    @Autowired
    private staffService staffService;
    @Autowired
    private subjectService subjectService;


    @GetMapping("/home1")
    public String returnHome(HttpSession session, ModelMap modelMap) {

        Member member = (Member) session.getAttribute("member");

        Staff staff = staffService.findStaff(member.getId());
        Teacher teacher = teacherService.findTeacher(staff.getIdMenber());

        List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(staff.getIdMenber());

        modelMap.addAttribute("listSubject", subjectList);
        modelMap.addAttribute("listPicked", pickedSectionClasses);
        String s = (String) session.getAttribute("error1");
        session.removeAttribute("error1");
        modelMap.addAttribute("error1", s);

        session.setAttribute("teacher", teacher);
        return "register_schedule";
    }

    @GetMapping("delete/{id}")
    public String deletePicked(@PathVariable Integer id, ModelMap modelMap, HttpSession session) {
        PickedSectionClass pickedSectionClass = pickedSectionClassService.findById(id);
        if (pickedSectionClass.getReview() == 1) {
            session.setAttribute("error1", "Học phần đã được phê duyệt , Không thể xóa");
        } else {
            pickedSectionClassService.deleteById(id);
        }
        return "redirect:/home1";
    }

    @RequestMapping("review/save-list-picked")
    public String SaveListPickedSectionClass(@RequestParam("idPickeds") String idPickedsString, ModelMap modelMap, HttpSession session) {
        List<Integer> idPickeds = Arrays.stream(idPickedsString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (idPickeds.isEmpty()) {
            modelMap.addAttribute("error", "Chọn 1 Lớp học phần để lưu");
        } else {
            List<PickedSectionClass> pickedSectionClasses = new ArrayList<>();
            for (Integer id : idPickeds) {
                PickedSectionClass pickedSectionClass = pickedSectionClassService.findById(id);
                pickedSectionClass.setReview(1);
                pickedSectionClassService.save(pickedSectionClass);
                pickedSectionClasses.add(pickedSectionClass);
            }
        }

        Member member = (Member) session.getAttribute("member");

        Staff staff = staffService.findStaff(member.getId());
        Teacher teacher = teacherService.findTeacher(staff.getIdMenber());

        List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllByIdDepartment(teacher.getDepartment().getId());

        modelMap.addAttribute("listSubject", subjectList);
        modelMap.addAttribute("listPicked", pickedSectionClasses);

        List<Teacher> teacherList = (List<Teacher>) session.getAttribute("teacherList");
//        List<Subject> subjectList = (List<Subject>) session.getAttribute("listSubject");
//        List<PickedSectionClass> pickedSectionClasses = (List<PickedSectionClass>) session.getAttribute("listPicked");
        modelMap.addAttribute("teacherList", teacherList);
//        modelMap.addAttribute("subjectList", subjectList);
//        modelMap.addAttribute("listPicked", pickedSectionClasses);
        return "review";
    }

}
