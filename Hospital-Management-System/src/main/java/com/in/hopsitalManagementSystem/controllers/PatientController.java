package com.in.hopsitalManagementSystem.controllers;

import com.in.hopsitalManagementSystem.services.PatientService;
import com.in.hopsitalManagementSystem.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){
        System.out.println("creating a patient details..");
        return patientService.createPatient(patient);
    }

    @GetMapping
    public Page<Patient> getAllPatient(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size){
        System.out.println("getting all patients list...");
        return patientService.getAllPatients(page, size);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        System.out.println("fetching patient by id");
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public Patient updatePatientById(@PathVariable Long id, @RequestBody Patient patient){
        System.out.println("updating Patient details");
        return  patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable Long id){
        patientService.deletePatient(id);
        System.out.println("Deleting Patient details");
    }
}
