package com.example.Teacher.service;

import com.example.Teacher.entities.SectionClass;

import java.util.List;

public interface sectionClassService {
    public List<SectionClass> getSectionClass( int idSoS );

    public SectionClass findById(int id);

    public List<SectionClass> findSectionClassesNotPicked();
}
