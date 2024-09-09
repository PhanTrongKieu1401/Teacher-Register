package com.example.Teacher.repository;

import com.example.Teacher.entities.SectionClass;
import com.example.Teacher.respository.sectionClassRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class SectionClassRepositoryTest {

    @Autowired
    private sectionClassRepository sectionClassRepository;

    @Autowired
    private TestEntityManager entityManager;

    //Lấy tất cả lớp học phần theo id môn học của học kỳ có tồn tại
    @Test
    @DisplayName("Lấy tất cả LHP chuẩn")
    public void testGetAllSectionClassByIdSosStandard(){
        int idSubjectOfSemesterTest = 1;

        List<SectionClass> sectionClasses = sectionClassRepository.getALLSectionClassByIdSos(idSubjectOfSemesterTest);

        Assertions.assertNotNull(sectionClasses);
        Assertions.assertEquals(1,sectionClasses.size());
        for(SectionClass sectionClass : sectionClasses){
            Assertions.assertEquals("Danh cho D20CNPM1",sectionClass.getDescription());
            Assertions.assertEquals(1,sectionClass.getId());
        }
    }

    //Lấy tất cả lớp học phần theo id môn học của học kỳ không tồn tại
    @Test
    @DisplayName("Lấy tất cả LHP ngoại lệ")
    public void testGetAllSectionClassByIdSosException(){
        int idSubjectOfSemesterTest = 0;

        List<SectionClass> sectionClasses = sectionClassRepository.getALLSectionClassByIdSos(idSubjectOfSemesterTest);

        Assertions.assertNotNull(sectionClasses);
        Assertions.assertEquals(0,sectionClasses.size());
    }

    //Lấy được tất cả lớp học phần không được chọn và vẫn còn lớp học phần chưa được chọn
    @Test
    @DisplayName("Lấy LHP chưa chọn chuẩn 1")
    public void testFindSectionClassesNotPickedStandard1(){
        List<SectionClass> sectionClasses = sectionClassRepository.findSectionClassesNotPicked();

        Assertions.assertNotNull(sectionClasses);
        Assertions.assertEquals(15,sectionClasses.size());
    }

    //Lấy được tất cả lớp học phần không được chọn và không còn lớp học phần chưa được chọn
    @Test
    @DisplayName("Lấy LHP chưa chọn chuẩn 2")
    public void testFindSectionClassesNotPickedStandard2(){
        List<SectionClass> sectionClasses = sectionClassRepository.findSectionClassesNotPicked();

        Assertions.assertNotNull(sectionClasses);
        System.out.println(sectionClasses.size());
        Assertions.assertEquals(0,sectionClasses.size());
    }

    @Test
    @DisplayName("Bắt ngoại lệ")
    public void testFindSectionClassesNotPickedException() {
        assertThrows(Exception.class, () -> {
            sectionClassRepository.findSectionClassesNotPicked();
        });
    }
}
