package com.example.Teacher.respository;

import com.example.Teacher.entities.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface semesterRepository extends JpaRepository<Semester,Integer> {

}
