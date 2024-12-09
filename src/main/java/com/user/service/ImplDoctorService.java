package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Doctor;
import com.user.repository.doctor.DoctorRepository;

@Service
public class ImplDoctorService implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Override
	public List<Doctor> getAllDoctors() {
		
		return doctorRepository.findAll();
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		// TODO Auto-generated method stub
		 Doctor existingDoctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
	        existingDoctor.setName(doctor.getName());
	        existingDoctor.setSpecialization(doctor.getSpecialization());
	        existingDoctor.setPhone(doctor.getPhone());
	        existingDoctor.setEmail(doctor.getEmail());
	        return doctorRepository.save(existingDoctor);
	}

	@Override
	public void deleteDoctor(Long id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);
	}

}
