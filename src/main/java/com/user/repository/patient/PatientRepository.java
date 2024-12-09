package com.user.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
