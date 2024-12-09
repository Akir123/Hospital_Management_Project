package com.user.repository.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
