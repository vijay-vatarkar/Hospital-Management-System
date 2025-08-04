package com.in.hopsitalManagementSystem.services;



import com.in.hopsitalManagementSystem.models.Appointment;
import com.in.hopsitalManagementSystem.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AppointmentService {

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Page<Appointment> getAllAppointments(int page, int size){
        try{
            System.out.println("Into Service Layer of Appointment..");
            Pageable pageable = PageRequest.of(page, size);
            return appointmentRepository.findAll(pageable);
        } catch (Exception e) {
            logger.error("An error occurred while fetching all Appointments : {}", e.getMessage());
            return null;
        }
    }

    public Appointment createAppointment(Appointment appointment){
        try{
            System.out.println("Creating Appointment");
            appointmentRepository.save(appointment);
            return appointment;
        } catch (Exception e) {
            logger.error("An error occurred while creating Appointments : {}", e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id){
        try{
            System.out.println("Getting Appointment By Id");
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            return appointment.orElse(null);
        } catch (Exception e) {
            logger.error("An error occurred while fetching Appointment with id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public Appointment updateAppointment(Long id, Appointment appointment){
        try{
            System.out.println("Updating Appointment");
            Optional<Appointment> existingAppointment = appointmentRepository.findById(id);
            if(existingAppointment.isPresent()){
                Appointment a = existingAppointment.get();
                a.setDate(appointment.getDate());
                a.setDoctorId(appointment.getDoctorId());
                a.setPatientId(appointment.getPatientId());

                appointmentRepository.save(a);
            }else {
                logger.error("Appointment with id{} not found", id);
            }
            return null;
        } catch (Exception e) {
            logger.error("An error occurred while updating Appointment with id {} : {}", id, e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id){
        try{
            System.out.println("Deleting Appointment");
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("An error occurred while deleting Appointment with id {} : {}", id, e.getMessage());
        }
    }
}
