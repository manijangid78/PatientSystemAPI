package com.example.PatientSystem.controller;

import com.example.PatientSystem.model.BookAppointment;
import com.example.PatientSystem.model.Patient;
import com.example.PatientSystem.service.PService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private PService patientService;

    @RequestMapping(value = "addPatient", method = RequestMethod.POST)
    public boolean addPatient(@RequestBody String body){
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(body);
        Patient patient1 = gson.fromJson(jsonObject,Patient.class);
        return patientService.addPatient(patient1);
    }

    @RequestMapping(value = "deletePatient", method = RequestMethod.DELETE)
    public boolean deletePatient(@RequestBody String body){
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(body);
        Patient patient1 = gson.fromJson(jsonObject,Patient.class);
//        System.out.println(email);
        return patientService.deletePatient(patient1.getEmail());
//        return true;
    }

    @RequestMapping(value = "updatePatient", method = RequestMethod.PUT)
    public boolean updatePatient(@RequestBody String body){
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject object = new JsonObject();
        Patient patient = gson.fromJson(object, Patient.class);
        return patientService.updatePatient(patient);
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @RequestMapping(value = "bookAppointment", method = RequestMethod.POST)
    public boolean bookAppointment(@RequestBody String body){
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject object = new JsonObject();
        BookAppointment bookAppointment = gson.fromJson(object, BookAppointment.class);
        System.out.println(bookAppointment.toString());
        return patientService.bookAppointment(bookAppointment);
    }

    @RequestMapping(value = "allAppointment", method = RequestMethod.GET)
    public List<BookAppointment> getAllAppointment(){
        return getAllAppointment();
    }

}
