package com.example.Teacher.respository;

import com.example.Teacher.entities.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface periodRepository extends JpaRepository<Period , Integer> {
    @Query(value = "SELECT p from Period p where p.id = :idSchedule ")
    public List<Period> getAllByIdSchdule(int idSchedule);
}
