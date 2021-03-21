package com.example.PatientSystem.repository;

import com.example.PatientSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, String> {
    List<Patient> findAllByOrderByEmailAsc();
}
