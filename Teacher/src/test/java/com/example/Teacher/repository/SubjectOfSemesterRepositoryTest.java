package com.example.Teacher.repository;

import com.example.Teacher.entities.*;
import com.example.Teacher.respository.subjectOfSemesterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class SubjectOfSemesterRepositoryTest {

    @Autowired
    private subjectOfSemesterRepository subjectOfSemesterRepository;

    @Autowired
    private TestEntityManager entityManager;

    private List<SubjectOfSemester> subjectOfSemesterList;

    @Test
    public void testFindSubjectOfSemesterBySubject_standard() {
        // Given
        Department department = new Department();
        entityManager.persist(department);


        Subject subject1 = new Subject();

        subject1.setName("Test Subject");
        subject1.setDepartment(department);
        entityManager.persist(subject1);


        Semester semester = new Semester();
        entityManager.persist(semester);

        SectionClass sectionClass = new SectionClass();
        entityManager.persist(sectionClass);

        SubjectOfSemester subjectOfSemester = new SubjectOfSemester();
        subjectOfSemester.setSubject(subject1);
        subjectOfSemester.setSemester(semester);
        entityManager.persist(subjectOfSemester);

        // mang subjectOfSemester
        subjectOfSemesterList = new ArrayList<>();
        subjectOfSemesterList.add(subjectOfSemester);

        // When
        List<SubjectOfSemester> foundSubjects = subjectOfSemesterRepository.findSubjectOfSemesterBySubject(subject1.getId());

        // Kiểm tra các kết quả trả về
        Assertions.assertNotNull(foundSubjects);
        Assertions.assertEquals(1, foundSubjects.size());
        Assertions.assertEquals(subjectOfSemester.getId(), foundSubjects.get(0).getId());
        // Kiểm tra Danh sách subjectOfSemester mong đợi và nhận được
        Assertions.assertEquals(subjectOfSemesterList, foundSubjects);
    }

    @Test
    public void testFindSubjectOfSemesterBySubject_exception() {
        // Given
        int nonExistentSubjectId = 999;

        Department department = new Department();
        entityManager.persist(department);


        Subject subject1 = new Subject();

        subject1.setName("Test Subject");
        subject1.setDepartment(department);
        entityManager.persist(subject1);


        Semester semester = new Semester();
        entityManager.persist(semester);

        SectionClass sectionClass = new SectionClass();
        entityManager.persist(sectionClass);

        SubjectOfSemester subjectOfSemester = new SubjectOfSemester();
        subjectOfSemester.setSubject(subject1);
        subjectOfSemester.setSemester(semester);
        entityManager.persist(subjectOfSemester);




        // When
        List<SubjectOfSemester> foundSubjects = subjectOfSemesterRepository.findSubjectOfSemesterBySubject(nonExistentSubjectId);

        // Kiểm tra các kết quả trả về
        Assertions.assertTrue(foundSubjects.isEmpty());

    }

}
