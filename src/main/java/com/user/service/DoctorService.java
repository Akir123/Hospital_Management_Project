package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.Doctor;

@Service
public interface DoctorService {
public List<Doctor> getAllDoctors();
public Doctor saveDoctor(Doctor doctor);
public Doctor updateDoctor(Long id, Doctor doctor);
public void deleteDoctor(Long id);
}
