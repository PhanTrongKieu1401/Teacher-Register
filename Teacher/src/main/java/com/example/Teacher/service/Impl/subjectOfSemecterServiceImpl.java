package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class subjectOfSemecterServiceImpl implements subjectOfSemesterService{
    @Autowired
    private subjectOfSemesterRepository subjectOfSemesterRepository;

    @Override
    public List<SubjectOfSemester> finfAllSosByIdSubject(int id) {
        return subjectOfSemesterRepository.findSubjectOfSemesterBySubject(id);
    }
}
