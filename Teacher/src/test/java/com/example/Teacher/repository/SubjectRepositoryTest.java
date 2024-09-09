
package com.example.Teacher.repository;

import com.example.Teacher.entities.Department;
import com.example.Teacher.entities.Subject;
import com.example.Teacher.respository.subjectRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class SubjectRepositoryTest {

    @Autowired
    private subjectRepository subjectRepository;

    @Autowired
    private TestEntityManager entityManager;

    private List<Subject> subjects;

    @Test
    public void testGetAllByInDepartment_exception() {
        // Given
        Department department = new Department();
        department.setName("Test Department");
        entityManager.persist(department);

        subjects = new ArrayList<>();
        // Create subjects belonging to the department
        Subject subject1 = new Subject();
        subject1.setName("Subject 1");
        subject1.setDepartment(department);
        entityManager.persist(subject1);


        Subject subject2 = new Subject();
        subject2.setName("Subject 2");
        subject2.setDepartment(department);
        entityManager.persist(subject2);


        // Create a subject not belonging to the department
        Department anotherDepartment = new Department();
        entityManager.persist(anotherDepartment);

        Subject subject3 = new Subject();
        subject3.setName("Subject 3");
        subject3.setDepartment(anotherDepartment);
        entityManager.persist(subject3);

        int nonExistentDepartmentId = 999;

        List<Subject> subjectsInNonExistentDepartment = subjectRepository.getAllByInDepartment(nonExistentDepartmentId);

        Assertions.assertTrue(subjectsInNonExistentDepartment.isEmpty());

    }

    @Test
    public void testGetAllByInDepartment_standard() {
        // Given
        Department department = new Department();
        department.setName("Test Department");
        entityManager.persist(department);

        subjects = new ArrayList<>();
        // Create subjects belonging to the department
        Subject subject1 = new Subject();
        subject1.setName("Subject 1");
        subject1.setDepartment(department);
        entityManager.persist(subject1);
        subjects.add(subject1);

        Subject subject2 = new Subject();
        subject2.setName("Subject 2");
        subject2.setDepartment(department);
        entityManager.persist(subject2);
        subjects.add(subject2);

        // Create a subject not belonging to the department
        Department anotherDepartment = new Department();
        entityManager.persist(anotherDepartment);

        Subject subject3 = new Subject();
        subject3.setName("Subject 3");
        subject3.setDepartment(anotherDepartment);
        entityManager.persist(subject3);



        List<Subject> subjectsInDepartment = subjectRepository.getAllByInDepartment(department.getId());

        // Kiểm tra các kết quả trả về
        Assertions.assertNotNull(subjectsInDepartment);
        Assertions.assertEquals(2, subjectsInDepartment.size());
        // Kiểm tra xem List Subject nhận được có bao gồm subject1 và subject2 không
        Assertions.assertTrue(subjectsInDepartment.contains(subject1));
        Assertions.assertTrue(subjectsInDepartment.contains(subject2));
        // Kiểm tra List Subject mong đợi với List Subject nhận được
        Assertions.assertEquals(subjects, subjectsInDepartment);
    }

    @Test
    public void testFindById_standard() {
        // Given
        //subject1
        Subject subject1 = new Subject();
        subject1.setName("Test Subject");
        entityManager.persist(subject1);

        //subject2
        Subject subject2 = new Subject();
        subject2.setName("Test Subject");
        entityManager.persist(subject2);


        // When
        Optional<Subject> optionalSubject = subjectRepository.findById(subject1.getId());

        // Then
        Assertions.assertTrue(optionalSubject.isPresent());
        Assertions.assertEquals(subject1, optionalSubject.get());

    }

    @Test
    public void testFindById_exception() {
        // Given
        //subject1
        Subject subject1 = new Subject();
        subject1.setName("Test Subject");
        entityManager.persist(subject1);

        //subject2
        Subject subject2 = new Subject();
        subject2.setName("Test Subject");
        entityManager.persist(subject2);


        int nonExistentSubjectId = 999;
        // When
        Optional<Subject> optionalSubject = subjectRepository.findById(nonExistentSubjectId);

        // Then
        Assertions.assertTrue(optionalSubject.isEmpty());

    }
}
