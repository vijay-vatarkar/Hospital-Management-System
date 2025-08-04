package com.in.hopsitalManagementSystem.controllers;

import com.in.hopsitalManagementSystem.services.AppointmentService;
import com.in.hopsitalManagementSystem.models.Appointment;
import com.in.hopsitalManagementSystem.services.WebhookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/api/v1/appointment"})
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    private WebhookService webhookService;

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointmentRequest){
        System.out.println("creating appointment..");
        Appointment appointment = appointmentService.createAppointment(appointmentRequest);

        Map<String, Object> payload = new HashMap<>();
        payload.put("appointentId", appointment.getAppointmentId() );
        payload.put("patientId", appointment.getPatientId());
        payload.put("doctorId", appointment.getDoctorId());
        payload.put("appointmentDate", appointment.getDate());

        //send the webhook
        String webhookURL = "http://localhost:8081/webhook"; //replace with your actual webhook.
        webhookService.sendWebhook(webhookURL, payload);
        return appointment;
    }

    @GetMapping
    public Page<Appointment> getAllAppointments(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size){
        System.out.println("getting all Appointments list...");
        return appointmentService.getAllAppointments(page,size);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        System.out.println("fetching Appointments by ID:"+ id);
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointmentById(@PathVariable Long id, @RequestBody Appointment appointment){
        System.out.println("upadated Appointment with ID:"+ id);
        return appointmentService.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointmentById(@PathVariable Long id){
        System.out.println("Deleting Appointment with ID:"+ id);
        appointmentService.deleteAppointment(id);
    }
}
