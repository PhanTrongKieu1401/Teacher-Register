package com.example.Teacher.respository;

import com.example.Teacher.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface scheduleRespository extends JpaRepository<Schedule,Integer> {
    @Query (value = "select s from Schedule s where s.sectionClass.id = :idsectionClass")
    public List<Schedule> getScheduleByIdSectionClass(int idsectionClass);
}
