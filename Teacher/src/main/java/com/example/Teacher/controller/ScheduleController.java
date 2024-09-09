package com.example.Teacher.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.PushBuilder;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import com.example.Teacher.service.*;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class ScheduleController {

    @Autowired
    private scheduleService scheduleService;
    @Autowired
    private pickedSectionClassService pickedSectionClassService;
    @Autowired
    private teacherService teacherService;

    @GetMapping("/schedule/{id}")
    public String getAllScheduleByIdSos(@PathVariable Integer id, HttpSession session, ModelMap modelMap) {
        Member member = (Member) session.getAttribute("member");
        Teacher teacher = teacherService.findTeacher(member.getId());
        List<String> stringList = ConvertListScheduleToString(teacher.getId());

        Schedule schedule = scheduleService.findById(id);
        String str = schedule.getDay().getName() + schedule.getPeriod().getName();

        Subject subject = (Subject) session.getAttribute("subject");
        session.removeAttribute("subject");
        Boolean check = CheckDuplicateSchedule(str, stringList);
        List<PickedSectionClass> pickedSectionClasses = pickedSectionClassService.getAllbyId(member.getId());
        modelMap.addAttribute("listPicked", pickedSectionClasses);

        if (check == true) {
            savePickedSectionClassByIdSchedule(schedule, teacher);
        } else {
            session.setAttribute("error", "Lớp học phần được chọn đã bị trùng !");
        }
        return "redirect:/subject/" + subject.getId();
    }

    @GetMapping("review/save-picked")
    public String saveChangePickedByTeacher(@RequestParam("idpicked") Integer pickedId,
                                            @RequestParam("idteacher") Integer teacherId, ModelMap modelMap, HttpSession session) {

        Teacher teacher = teacherService.findTeacher(teacherId);
        session.setAttribute("teacher", teacher);
        PickedSectionClass pickedSectionClass = pickedSectionClassService.findById(pickedId);

        List<String> stringList = ConvertListScheduleToString(teacher.getId());
        Schedule schedule = pickedSectionClass.getSectionClass().getSchedules().get(0);
        String str = schedule.getDay().getName() + schedule.getPeriod().getName();

        Boolean check = CheckDuplicateSchedule(str, stringList);
        Subject subject = (Subject) session.getAttribute("subjectReview");
        if (check == true) {
            pickedSectionClass.setTeacher(teacher);
            pickedSectionClassService.save(pickedSectionClass);
        } else {
            session.setAttribute("error2", "Giảng viên được chọn đã bị trùng lịch dạy!");
//            modelMap.addAttribute("error", "Lớp học phần được chọn đã bị trùng !");
        }
        return "redirect:/home2";
    }

    @PostMapping("review/check/{idSectionClass}")
    public String CheckDuplicatereview(@PathVariable Integer idSectionClass, @PathVariable Integer IdTeacher, ModelMap modelMap, HttpSession session) {
        Teacher teacher = teacherService.findTeacher(IdTeacher);
        List<String> stringList = ConvertListScheduleToString(IdTeacher);

        Schedule schedule = getScheduleByIdSectionClass(idSectionClass);
        String str = schedule.getDay().getName() + schedule.getPeriod().getName();

        Boolean check = CheckDuplicateSchedule(str, stringList);
        if (check == true) {
            schedule.setTeacher(teacher);
            savePickedSectionClassByIdSchedule(schedule, teacher);
        } else {
            modelMap.addAttribute("error", "Lớp học phần được chọn đã bị trùng !");
        }
        return "redirect:/review/subject/" + (int) session.getAttribute("idSubject");

    }

    public boolean CheckDuplicateSchedule(String str, List<String> list) {
        for (String s : list) {
            if (str.equals(s)) return false;
        }
        return true;
    }

    public List<String> ConvertListScheduleToString(int idTeacher) {
        List<PickedSectionClass> pickedSectionClassList = GetListPickedSectionClassByIdTeacher(idTeacher);
        List<SectionClass> sectionClassList = getListSectionClassByListPickedSectionClass(pickedSectionClassList);
        List<Schedule> scheduleList = getALlListScheduleByListSectionClass(sectionClassList);

        List<String> list = new ArrayList<>();
        for (Schedule s : scheduleList) {
            String str = "";
            str = str + s.getDay().getName() + s.getPeriod().getName();
            list.add(str);
        }
        return list;
    }

    public List<PickedSectionClass> GetListPickedSectionClassByIdTeacher(int idTeacher) {
        List<PickedSectionClass> list = pickedSectionClassService.getAllbyId(idTeacher);
        return list;
    }

    public List<SectionClass> getListSectionClassByListPickedSectionClass(List<PickedSectionClass> list) {
        List<SectionClass> sectionClassList = new ArrayList<>();
            for (PickedSectionClass p : list) {
                SectionClass s = p.getSectionClass();
                sectionClassList.add(s);
            }
            return sectionClassList;
        }

    public List<Schedule> getALlListScheduleByListSectionClass(List<SectionClass> sectionClassList) {
        List<Schedule> scheduleList = new ArrayList<>();
        for (SectionClass s : sectionClassList) {
            List<Schedule> list = scheduleService.getScheduleByIdSectionClass(s.getId());
            for (Schedule sc : list) {
                scheduleList.add(sc);
                break;
            }
        }
        return scheduleList;
    }

    public Schedule getScheduleByIdSectionClass(int IdSectionClass) {
        List<Schedule> scheduleList = scheduleService.getScheduleByIdSectionClass(IdSectionClass);

        Schedule schedule = new Schedule();
        for (Schedule s : scheduleList) {
            schedule = s;
            break;
        }
        return schedule;
    }

    public void savePickedSectionClassByIdSchedule(Schedule schedule, Teacher teacher) {

        SectionClass sectionClass = schedule.getSectionClass();
        PickedSectionClass pickedSectionClass = new PickedSectionClass();
        pickedSectionClass.setTeacher(teacher);
        pickedSectionClass.setPickedTime(Time.valueOf(LocalTime.now()));
        pickedSectionClass.setIsPicked(1);
        pickedSectionClass.setReview(0);
        pickedSectionClass.setSectionClass(sectionClass);
        pickedSectionClassService.save(pickedSectionClass);

    }

}
