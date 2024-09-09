package com.example.Teacher.respository;

import com.example.Teacher.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface memberRespository extends JpaRepository<Member,Integer> {

    @Query(value = "SELECT m from Member m where m.username= :username and m.password = :password")
    Member checkLogin(String username , String password);

}
