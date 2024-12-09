package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.Patient;

@Service
public interface PatientService {
	public List<Patient> getAllPatients();
	public Patient savePatient(Patient patient);
	public Patient updatePatient(Long id, Patient patient);
	public void deletePatient(Long id);
}
