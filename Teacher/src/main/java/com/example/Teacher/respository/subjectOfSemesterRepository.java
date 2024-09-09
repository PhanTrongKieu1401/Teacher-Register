package com.example.Teacher.respository;

import com.example.Teacher.entities.SubjectOfSemester;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface subjectOfSemesterRepository extends JpaRepository<SubjectOfSemester,Integer> {
    @Query(value = "select s from SubjectOfSemester s where s.semester.id = :id")
    List<SubjectOfSemester> findSubjectOfSemesterByIdSemester(int id);

    @Query(value = "select s from SubjectOfSemester s where s.subject.id = :id")
    List<SubjectOfSemester> findSubjectOfSemesterBySubject(int id);
}
