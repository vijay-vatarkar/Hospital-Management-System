package com.in.hopsitalManagementSystem.services;

import com.in.hopsitalManagementSystem.models.Doctor;
import com.in.hopsitalManagementSystem.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    private DoctorRepository doctorRepository;

    public Page<Doctor> getAllDoctors(int page, int size){
        try{
            System.out.println("Into Service Layer of Doctor..");
            Pageable pageable = PageRequest.of(page, size);
            return doctorRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("An error occurred while fetching all Doctors : {}", e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor){
        try{
            System.out.println("Creating Doctor");
            return doctorRepository.save(doctor);
        } catch (Exception e) {
            logger.error("An error occurred while creating doctor : {}", e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id){
        try{
            System.out.println("Getting Doctor By Id");
            Optional<Doctor> doctor = doctorRepository.findById(id);
            return doctor.orElse(null);
        } catch (Exception e) {
            logger.error("An error occurred while fetching doctor with id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public Doctor updateDoctor(Long id, Doctor updateDoctor){
        try{
            System.out.println("Updating Doctor");
            Optional<Doctor> existingDoctor = doctorRepository.findById(id);
            if(existingDoctor.isPresent()){
                Doctor d = existingDoctor.get();
                d.setDoctorName(updateDoctor.getDoctorName());
                d.setDoctorAge(updateDoctor.getDoctorAge());
                d.setSpeciality(updateDoctor.getSpeciality());

                doctorRepository.save(d);
                return updateDoctor;
            }else {
                logger.error("Doctor with id{} not found", id);
            }
            return null;
        } catch (Exception e) {
            logger.error("An error occurred while updating doctor with id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id){
        try{
            System.out.println("Deleting Doctor");
            doctorRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occurred while deleting doctor with id {} : {}", id, e.getMessage());
        }
    }
}
