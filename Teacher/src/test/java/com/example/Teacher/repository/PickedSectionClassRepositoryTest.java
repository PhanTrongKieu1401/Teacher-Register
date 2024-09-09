package com.example.Teacher.repository;

import com.example.Teacher.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.Teacher.respository.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@DataJpaTest
public class PickedSectionClassRepositoryTest {

    @Autowired
    private pickedSectionClassRepository pickedSectionClassRepository1;

    @Autowired
    private TestEntityManager entityManager;

    private PickedSectionClass pickedSectionClass1;
    private Teacher teacher;
    private SectionClass sectionClass;
    private Staff staff;
    private Member member;
    private Department department;
    private List<PickedSectionClass> pickedSectionClassList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // tạo bản ghi member
        member = new Member();
        entityManager.persist(member);

        // tạo bản ghi department
        department = new Department();
        entityManager.persist(department);

        // tạo bản ghi staff
        staff = new Staff();
        staff.setMember(member);
        entityManager.persist(staff);

        // tạo bản ghi teacher
        teacher = new Teacher();
        teacher.setStaff(staff);
        teacher.setDepartment(department);
        entityManager.persist(teacher);

        // tạo bản ghi sectionClass
        sectionClass = new SectionClass();
        entityManager.persist(sectionClass);

        // tạo bản ghi pickedSectionClass
        pickedSectionClass1 = new PickedSectionClass();
        pickedSectionClass1.setPickedTime(new Date());
        pickedSectionClass1.setIsPicked(1);
        pickedSectionClass1.setSectionClass(sectionClass);
        pickedSectionClass1.setCode("ABCD");
        pickedSectionClass1.setReview(0);
        pickedSectionClass1.setTeacher(teacher);
        entityManager.persist(pickedSectionClass1);

        // mảng pickedSectionClass
        pickedSectionClassList = new ArrayList<>();
        pickedSectionClassList.add(pickedSectionClass1);
    }

    @Test
    public void testSave_ShouldSavePickedSectionClass(){
        PickedSectionClass pickedSectionClass = pickedSectionClassRepository1.save(pickedSectionClass1);
//        Assertions.assertEquals(3, pickedSectionClass.getId());
        Assertions.assertEquals(pickedSectionClass1.getCode(), pickedSectionClass.getCode());
        Assertions.assertEquals(pickedSectionClass1.getReview(), pickedSectionClass.getReview());
        Assertions.assertEquals(pickedSectionClass1.getIsPicked(), pickedSectionClass.getIsPicked());
    }

    @Test
    public void testGetAllById_ShouldReturnPickedSectionClassesForTeacher(){
        int teacherId = teacher.getId();
        List<PickedSectionClass> list = pickedSectionClassRepository1.getById(teacherId);
        Assertions.assertNotEquals(Collections.emptyList(), list);
        Assertions.assertEquals(pickedSectionClassList, list);
    }

    @Test
    public void testGetAllByIdDepartment_ShouldReturnPickedSectionClassesForDepartment(){
        int departmentId = teacher.getDepartment().getId();
        List<PickedSectionClass> list = pickedSectionClassRepository1.getAllByIdDepartment(departmentId);
        Assertions.assertNotEquals(Collections.emptyList(), list);
        Assertions.assertEquals(pickedSectionClassList, list);
    }

    @Test
    public void testDeleteById_ShouldDeletePickedSectionClass(){
        int id = pickedSectionClass1.getId();

        System.out.println(pickedSectionClassRepository1.findAll().size());
        pickedSectionClassRepository1.deleteById(id);


        PickedSectionClass pickedSectionClass = entityManager.find(PickedSectionClass.class, id);
        Assertions.assertNull(pickedSectionClass);
        Assertions.assertEquals(0, pickedSectionClassRepository1.findAll().size());
    }

    @Test
    public void testFindById_ShouldReturnPickedSectionClass(){
        System.out.println(pickedSectionClass1.getId());
        PickedSectionClass pickedSectionClass2 = pickedSectionClassRepository1.findById(5).orElse(null);
        Assertions.assertNotNull(pickedSectionClass2);
        Assertions.assertEquals(pickedSectionClass1, pickedSectionClass2);
    }
}
