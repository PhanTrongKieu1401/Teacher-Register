package com.example.Teacher.repository;

import com.example.Teacher.entities.Member;
import com.example.Teacher.entities.Staff;
import com.example.Teacher.entities.Teacher;
import com.example.Teacher.respository.teacherRespository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class TeacherRepositoryTest {

    @Autowired
    private teacherRespository teacherRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindTeacher_standard() {
        // Given
        Member member = new Member();
        member.setName("Le Minh Nhat");
        entityManager.persist(member);


        Staff staff = new Staff();
        staff.setMember(member);
        entityManager.persist(staff);

        Teacher teacher = new Teacher();

        teacher.setStaff(staff);
        entityManager.persist(teacher);


        Teacher foundTeacher = teacherRepository.findTeacher(teacher.getId());

        // Then
        Assertions.assertNotNull(foundTeacher);
        Assertions.assertEquals(teacher, foundTeacher);
    }

    @Test
    public void testFindTeacher_exception() {
        // Given
        Member member = new Member();
        member.setName("Le Minh Nhat");
        entityManager.persist(member);


        Staff staff = new Staff();
        staff.setMember(member);
        entityManager.persist(staff);

        Teacher teacher = new Teacher();

        teacher.setStaff(staff);
        entityManager.persist(teacher);

        int nonExistentTeacherId = 999;
        Teacher foundTeacher = teacherRepository.findTeacher(nonExistentTeacherId);

        Assertions.assertNull(foundTeacher);
    }



}
