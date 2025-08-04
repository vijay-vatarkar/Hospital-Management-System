package com.in.hopsitalManagementSystem.services;

import com.in.hopsitalManagementSystem.models.Patient;
import com.in.hopsitalManagementSystem.repository.PatientRepository;
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
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    public Page<Patient> getAllPatients(int page, int size){
        try{
            System.out.println("Fetching all patients..");
            Pageable pageable = PageRequest.of(page, size);
            return patientRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("An error occurred while fetching all Patients : {}", e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient){
        try{
            System.out.println("Creating Patient..");
            patientRepository.save(patient);
            return patient;
        } catch (Exception e) {
            logger.error("An error occurred while creating Patients : {}", e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id){
        try{
            System.out.println("Getting Patient by Id..");
            Optional<Patient> patient = patientRepository.findById(id);
            return patient.orElse(null);
        } catch (Exception e) {
            logger.error("An error occurred while fetching with id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public Patient updatePatient(Long id, Patient updatePatient){
        try{
            System.out.println("Updating Patient...");
            Optional<Patient> existingPatient = patientRepository.findById(id);
            if(existingPatient.isPresent()){
                Patient p = existingPatient.get();
                p.setPatientName(updatePatient.getPatientName());
                p.setPatientAge(updatePatient.getPatientAge());
                p.setPatientGender(updatePatient.getPatientGender());

                patientRepository.save(p);

                return updatePatient;
            }else {
                logger.error("Patient with id{} not found", id);
                return null;
            }
        } catch (Exception e) {
            logger.error("An error occurred while updating patient with id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id){
        try{
            logger.info("Deleting patient with id: {}", id);
            patientRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occurred while deleting with id {} : {}", id, e.getMessage());
        }
    }
}
