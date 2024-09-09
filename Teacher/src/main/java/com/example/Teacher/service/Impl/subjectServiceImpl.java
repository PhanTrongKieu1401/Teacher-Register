package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class subjectServiceImpl  implements subjectService{
    @Autowired
    subjectRepository subjectRepository;
    @Override
    public List<Subject> getAll(int id) {
        return subjectRepository.getAllByInDepartment(id);
    }

    @Override
    public Subject findById(int id) {
        return subjectRepository.findById(id).orElse(null);
    }
}
