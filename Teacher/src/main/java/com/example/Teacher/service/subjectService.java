package com.example.Teacher.service;

import com.example.Teacher.entities.Subject;

import java.util.List;

public interface subjectService {

    public List<Subject> getAll(int id);

    public Subject findById(int id);
}
