package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sectionClassServiceImpl implements sectionClassService{
    @Autowired
    sectionClassRepository sectionClassRepository;

    @Override
    public List<SectionClass> getSectionClass(int id) {
        return sectionClassRepository.getALLSectionClassByIdSos(id);
    }

    @Override
    public SectionClass findById(int id) {
        return sectionClassRepository.findById(id).orElse(null);
    }

    @Override
    public List<SectionClass> findSectionClassesNotPicked() {
        return sectionClassRepository.findSectionClassesNotPicked();
    }
}
