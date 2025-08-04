package com.in.hopsitalManagementSystem.repository;

import com.in.hopsitalManagementSystem.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
