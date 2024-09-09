package com.example.Teacher.respository;

import com.example.Teacher.entities.PickedSectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface pickedSectionClassRepository extends JpaRepository<PickedSectionClass,Integer> {

    @Query (value = "select p from PickedSectionClass p where p.teacher.id =:id")
    public List<PickedSectionClass> getById(int id);
    @Query(value = "select p from PickedSectionClass p where p.teacher.department.id=:id")
    public List<PickedSectionClass>getAllByIdDepartment(int id);
    @Query(value = "select p from PickedSectionClass p where p.sectionClass.id=:id")
    public PickedSectionClass getPBySection(int id);

}
