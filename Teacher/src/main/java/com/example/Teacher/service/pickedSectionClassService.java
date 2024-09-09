package com.example.Teacher.service;

import com.example.Teacher.entities.PickedSectionClass;

import java.util.List;

public interface pickedSectionClassService {
    public void save(PickedSectionClass pickedSectionClass);
    public List<PickedSectionClass> getAllbyId(int id);

    public void deleteById(int id);

    public List<PickedSectionClass> getAllByIdDepartment(int id);

    public PickedSectionClass findById(int id);

}
