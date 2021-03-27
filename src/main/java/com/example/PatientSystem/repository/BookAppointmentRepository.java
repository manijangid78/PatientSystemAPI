package com.example.PatientSystem.repository;

import com.example.PatientSystem.model.BookAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookAppointmentRepository extends JpaRepository<BookAppointment, Integer> {
    List<BookAppointment> findAllByOrderByDateAsc();
}
