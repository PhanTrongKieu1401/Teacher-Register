package com.example.Teacher.repository;

import com.example.Teacher.entities.Member;
import com.example.Teacher.entities.Schedule;
import com.example.Teacher.entities.Staff;
import com.example.Teacher.respository.scheduleRespository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class ScheduleRepositoryTest {

    @Autowired
    private scheduleRespository scheduleRespository;

    @Autowired
    private TestEntityManager entityManager;

    //Lấy schedule theo id section class có tồn tại
    @Test
    @DisplayName("Lấy schedule chuẩn")
    public void testGetScheduleByIdSectionClassStandard() {
        int idSectionClassTest = 1;

        List<Schedule> schedules = scheduleRespository.getScheduleByIdSectionClass(idSectionClassTest);

        Assertions.assertNotNull(schedules);
        Assertions.assertEquals(7, schedules.size(), "Số lượng lịch trình không khớp!");
        for(Schedule schedule : schedules){
            Assertions.assertEquals("Kip 3 thu bay", schedule.getName(), "Sai tên lịch học!");
            Assertions.assertEquals("Bat dau vao luc 12h thu bay", schedule.getDescription(), "Sai mô tả lịch học!");
            Assertions.assertEquals(1, schedule.getSectionClass().getId(), "Sai lớp học phần!");
            Assertions.assertEquals(3, schedule.getPeriod().getId(), "Sai kíp học!");
            Assertions.assertEquals(6, schedule.getDay().getId(), "Sai ngày học!");
            Assertions.assertEquals(14, schedule.getClassroom().getId(), "Sai phòng học!");
        }
    }

    //Lấy schedule theo id section class không tồn tại
    @Test
    @DisplayName("Lấy schedule ngoại lệ")
    public void testGetScheduleByIdSectionClassException() {
        int idSectionClassTest = 0;

        List<Schedule> schedules = scheduleRespository.getScheduleByIdSectionClass(idSectionClassTest);

        Assertions.assertNotNull(schedules);
        Assertions.assertEquals(0, schedules.size(), "Số lượng lịch trình không khớp!");
    }

    @Test
    @DisplayName("Bắt ngoại lệ")
    public void testFindSectionClassesNotPickedException() {
        assertThrows(Exception.class, () -> {
            scheduleRespository.getScheduleByIdSectionClass(1);
        });
    }
}
