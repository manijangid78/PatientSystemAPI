package com.example.PatientSystem.repository;

import com.example.PatientSystem.model.BookAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAppointmentRepository extends JpaRepository<BookAppointment, Integer> {
}
