package com.example.Teacher.respository;

import com.example.Teacher.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface departmentRepository extends JpaRepository<Department,Integer> {
    @Query(value = "select d from Department d where d.id =:id ")
    public List<Department> getAllByIdTeacher(int id);
}
