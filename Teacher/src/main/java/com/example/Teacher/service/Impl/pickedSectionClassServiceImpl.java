package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pickedSectionClassServiceImpl implements pickedSectionClassService{
    @Autowired
    public pickedSectionClassRepository pickedSectionClassRepository;

    @Override
    public void save(PickedSectionClass pickedSectionClass) {
        pickedSectionClassRepository.save(pickedSectionClass);
    }

    @Override
    public List<PickedSectionClass> getAllbyId(int id) {
        return pickedSectionClassRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        pickedSectionClassRepository.deleteById(id);
    }

    @Override
    public List<PickedSectionClass> getAllByIdDepartment(int id) {
        return pickedSectionClassRepository.getAllByIdDepartment(id);
    }

    @Override
    public PickedSectionClass findById(int id) {
        return pickedSectionClassRepository.findById(id).orElse(null);
    }


}
