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

import com.user.entity.Patient;
import com.user.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Hospital Management", description = "CRUD Operation")
@RestController
@RequestMapping("/patient")
@SecurityRequirement(name = "OAuth2") // Secures all endpoints in the controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Operation(summary = "GET-REQUEST", description = "Get request from server to client")
    @PreAuthorize("hasAuthority('SCOPE_patient.read')") // Restrict to users with `patient.read` scope
    @GetMapping("/")
    public List<Patient> getAllPatient() {
        return patientService.getAllPatients();
    }

    @Operation(summary = "POST-REQUEST", description = "Post request from client to server")
    @PreAuthorize("hasAuthority('SCOPE_patient.write')") // Restrict to users with `patient.write` scope
    @PostMapping("/")
    public Patient saveAllPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @Operation(summary = "PUT-REQUEST", description = "Update request from server to client")
    @PreAuthorize("hasAuthority('SCOPE_patient.write')") // Restrict to users with `patient.write` scope
    @PutMapping("/{id}")
    public Patient updateAllPatient(@RequestBody Patient patient, @PathVariable Long id) {
        return patientService.updatePatient(id, patient);
    }

    @Operation(summary = "DELETE-REQUEST", description = "Delete request from server to client")
    @PreAuthorize("hasAuthority('SCOPE_patient.delete')") // Restrict to users with `patient.delete` scope
    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }
}
