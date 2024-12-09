package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Patient;
import com.user.repository.patient.PatientRepository;

@Service
public class ImplPatientService implements PatientService{
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Long id, Patient patient) {
		// TODO Auto-generated method stub
		Patient existingPatient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
		existingPatient.setName(patient.getName());
		existingPatient.setPhone(patient.getPhone());
		existingPatient.setEmail(patient.getEmail());
		existingPatient.setDisease(patient.getDisease());
		
		return patientRepository.save(existingPatient);
	}

	@Override
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
		
	}

}
