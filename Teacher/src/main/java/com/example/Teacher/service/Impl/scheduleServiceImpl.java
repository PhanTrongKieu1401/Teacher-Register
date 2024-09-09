package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class scheduleServiceImpl implements scheduleService{
    @Autowired
    private scheduleRespository scheduleRespository;

    @Override
    public List<Schedule> getScheduleByIdSectionClass(int idSectionClass) {
        return scheduleRespository.getScheduleByIdSectionClass(idSectionClass);
    }

    @Override
    public Schedule findById(int id) {
        return scheduleRespository.findById(id).orElse(null);
    }
}
