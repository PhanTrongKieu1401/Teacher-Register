package com.example.Teacher.service;

import com.example.Teacher.entities.Member;

public interface memberService {
    Member checkLogin(String username , String password);
}
