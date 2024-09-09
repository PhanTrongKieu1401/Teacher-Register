package com.example.Teacher.service.Impl;
import com.example.Teacher.service.*;
import com.example.Teacher.respository.*;
import com.example.Teacher.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class staffServiceImpl implements staffService {

    @Autowired
    staffRepository staffRepository;
    @Override
    public Staff findStaff(int idStaff) {
        return staffRepository.findStaff(idStaff);
    }
}
