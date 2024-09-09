package com.example.Teacher.respository;

import com.example.Teacher.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface staffRepository extends JpaRepository<Staff , Integer> {

    @Query(value = "SELECT s from Staff s where s.idMenber = :idMember")
    Staff findStaff(int idMember);
}
