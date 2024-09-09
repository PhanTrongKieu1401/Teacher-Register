package com.example.Teacher.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class SubjectController {
    @Autowired
    subjectService subjectService;
    @Autowired
    private subjectOfSemesterService subjectOfSemesterService;
    @Autowired
    private pickedSectionClassService pickedSectionClassService;
    @Autowired
    private sectionClassService sectionClassService;
    @Autowired
    private scheduleService scheduleService;

    @GetMapping("/subject/{id}")
    public String getAllSectionCalssBySubject(HttpSession session , @PathVariable Integer id,ModelMap modelMap){
        Member member = (Member) session.getAttribute("member");
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        List<Subject> subjectList = subjectService.getAll(teacher.getDepartment().getId());
        modelMap.addAttribute("listSubject",subjectList);

        List<SubjectOfSemester> subjectOfSemesterList = GetAllSubjectOfSemesterBySubject(id);

        List<SectionClass> sectionClassList = GetALLSectionClassByListSoS(subjectOfSemesterList);

        List<Schedule> scheduleList = getALlListScheduleByListSectionClass(sectionClassList);

        session.setAttribute("subject",subjectService.findById(id));
        modelMap.addAttribute("listSchedule",scheduleList);

        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(member.getId());

        String error = (String) session.getAttribute("error");
        if (error != null) {
            modelMap.addAttribute("error", error);
            session.removeAttribute("error");
        }
        modelMap.addAttribute("listPicked",pickedSectionClasses);


        return "register";
    }
    @GetMapping("/review/subject/{id}")
    public String getAllTeacherAndSectionClass(HttpSession session,ModelMap modelMap, @PathVariable Integer id){

        List<PickedSectionClass> pickedSectionClasses = new ArrayList<>();
        session.setAttribute("subjectReview" ,subjectService.findById(id));
        List<PickedSectionClass> list = (List<PickedSectionClass>) session.getAttribute("listPicked");
        System.out.println(list.size());
        for(PickedSectionClass p : list){
            if(p.getSectionClass().getSubjectOfSemester().getSubject().getId() == id){
                pickedSectionClasses.add(p);
            }
        }

        List<Subject> subjectList = (List<Subject>) session.getAttribute("listSubject");

        List<Teacher> teacherList = (List<Teacher>) session.getAttribute("teacherList");

        modelMap.addAttribute("listPicked",pickedSectionClasses);
        modelMap.addAttribute("listSubject",subjectList);
        modelMap.addAttribute("teacherList",teacherList);
        return "review";
    }

    public List<SubjectOfSemester> GetAllSubjectOfSemesterBySubject(int id){
        List<SubjectOfSemester>subjectOfSemesterList = new ArrayList<>();
        subjectOfSemesterList = subjectOfSemesterService.finfAllSosByIdSubject(id);
        return  subjectOfSemesterList;
    }
    public List<SectionClass> GetALLSectionClassByListSoS(List<SubjectOfSemester> subjectOfSemesterList){
        List<SectionClass> sectionClassList = new ArrayList<>();
        for (SubjectOfSemester s : subjectOfSemesterList){
            List<SectionClass> list = sectionClassService.getSectionClass(s.getId());
            for(SectionClass se : list) sectionClassList.add(se);
        }
        List <SectionClass> list1 = sectionClassService.findSectionClassesNotPicked();
        List <SectionClass> newList = new ArrayList<>();
        for(SectionClass s1 : list1){
            for(SectionClass s2 : sectionClassList){
                if(s2 == s1) newList.add(s1);
            }
        }
        return  newList;
    }

    public List<Schedule> getALlListScheduleByListSectionClass(List<SectionClass>sectionClassList){
        List<Schedule> scheduleList = new ArrayList<>();
        for(SectionClass s : sectionClassList){
            List<Schedule> list = scheduleService.getScheduleByIdSectionClass(s.getId());
            for(Schedule sc : list){
                scheduleList.add(sc);
                break;
            }
        }
        return scheduleList;
    }

}
