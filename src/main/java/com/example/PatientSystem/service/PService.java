package com.example.PatientSystem.service;

import com.example.PatientSystem.model.BookAppointment;
import com.example.PatientSystem.model.Patient;
import com.example.PatientSystem.repository.BookAppointmentRepository;
import com.example.PatientSystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PService {


    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private BookAppointmentRepository bookAppointmentRepository;

    public boolean addPatient(Patient patient){
        try {
            System.out.println(patient.toString());
            patientRepository.save(patient);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean deletePatient(String email){
        try{
            patientRepository.deleteById(email);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean updatePatient(Patient patient){
        try{
            Patient p = patientRepository.getOne(patient.getEmail());
            p.setAddress(patient.getAddress());
            p.setMobileNumber(patient.getMobileNumber());
            p.setName(patient.getName());
            p.setPassword(patient.getPassword());
            patientRepository.save(p);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<Patient> getAllPatient(){
        return patientRepository.findAllByOrderByEmailAsc();
    }

    public boolean bookAppointment(BookAppointment bookAppointment){
        try{
            bookAppointmentRepository.save(bookAppointment);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<BookAppointment> getAllBookAppointment(){
        return bookAppointmentRepository.findAll();
    }

}
