package com.example.Teacher.respository;

import com.example.Teacher.entities.Staff;
import com.example.Teacher.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface teacherRespository extends JpaRepository<Teacher,Integer> {
    @Query(value = "select t from Teacher t where t.id = :idStaff")
    Teacher findTeacher(int idStaff);
    @Query(value = "select t from Teacher t where t.id = :idDepartment")
    List<Teacher> findAllByIdDepartment(int idDepartment);
}
