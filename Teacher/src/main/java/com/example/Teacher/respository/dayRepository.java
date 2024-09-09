package com.example.Teacher.respository;

import com.example.Teacher.entities.Schedule;
import com.example.Teacher.entities.day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface dayRepository extends JpaRepository<day, Integer> {
    @Query(value = "select d from day d where d.id = :idSchedule")
    public List<day> getAllByIdSchedule(int idSchedule);
}
