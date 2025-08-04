package com.in.hopsitalManagementSystem.controllers;

import com.in.hopsitalManagementSystem.services.DoctorService;
import com.in.hopsitalManagementSystem.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping({"/api/v1/doctors"})
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        System.out.println("creating a doctor details..");
        return doctorService.createDoctor(doctor);
    }

    @GetMapping
    public Page<Doctor> getAllDoctor(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size){
        System.out.println("getting all Doctors list...");
        return doctorService.getAllDoctors(page, size);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id){
        System.out.println("fetching Doctor by id");
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctorById(@PathVariable Long id, @RequestBody Doctor doctor){
        System.out.println("upadated doctor details");
        return doctorService.updateDoctor(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void deletePatientById(@PathVariable Long id){
        System.out.println("Deleting doctor details");
        doctorService.deleteDoctor(id);
    }
}
