package com.example.Teacher.respository;

import com.example.Teacher.entities.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface weekRepository extends JpaRepository<Week, Integer> {

    @Query(value = "select w from Week w where w.id =:idSchedule")
    public List<Week> getAllByIdSchedule(int idSchedule);
}
