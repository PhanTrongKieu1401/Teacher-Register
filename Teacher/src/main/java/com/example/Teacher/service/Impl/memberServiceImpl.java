package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class memberServiceImpl implements memberService {

    @Autowired
    private memberRespository memberRespository;

    @Override
    public Member checkLogin(String username, String password) {
        return memberRespository.checkLogin(username,password);
    }
}
