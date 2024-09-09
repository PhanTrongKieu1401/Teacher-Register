package com.example.Teacher.respository;

import com.example.Teacher.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface subjectRepository extends JpaRepository<Subject,Integer> {
    @Query(value = "select s from Subject s where s.department.id= :id")
    public List<Subject> getAllByInDepartment(int id);

}
