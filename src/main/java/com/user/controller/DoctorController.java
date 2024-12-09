package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Doctor;
import com.user.service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Hospital Management", description = "CRUD Operation for Doctor Entity")
@RestController
@RequestMapping("/doctor")
@SecurityRequirement(name = "OAuth2") // Secures all endpoints in the controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Operation(summary = "GET-REQUEST", description = "Get all doctors")
    @PreAuthorize("hasAuthority('SCOPE_doctor.read')") // Access restricted to `doctor.read` scope
    @GetMapping("/")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @Operation(summary = "POST-REQUEST", description = "Save a new doctor")
    @PreAuthorize("hasAuthority('SCOPE_doctor.write')") // Access restricted to `doctor.write` scope
    @PostMapping("/")
    public Doctor saveAllDoctors(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @Operation(summary = "PUT-REQUEST", description = "Update an existing doctor")
    @PreAuthorize("hasAuthority('SCOPE_doctor.write')") // Access restricted to `doctor.write` scope
    @PutMapping("/{id}")
    public Doctor updateAllDoctors(@PathVariable Long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @Operation(summary = "DELETE-REQUEST", description = "Delete a doctor")
    @PreAuthorize("hasAuthority('SCOPE_doctor.delete')") // Access restricted to `doctor.delete` scope
    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}
