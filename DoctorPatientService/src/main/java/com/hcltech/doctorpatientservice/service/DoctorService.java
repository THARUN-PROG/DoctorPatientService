package com.hcltech.doctorpatientservice.service;

import com.hcltech.doctorpatientservice.dao.DoctorDAO;
import com.hcltech.doctorpatientservice.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {
    private DoctorDAO doctorDAO;
    @Autowired
    public DoctorService(DoctorDAO doctorDAO) {
        this.doctorDAO=doctorDAO;
    }

    public List<Doctor> getAll() {
        return doctorDAO.getAll();
    }
}
