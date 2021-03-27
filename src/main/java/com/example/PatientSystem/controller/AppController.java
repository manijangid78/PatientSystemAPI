package com.example.PatientSystem.controller;

import com.example.PatientSystem.model.AuthenticateRequest;
import com.example.PatientSystem.model.AuthenticateResponse;
import com.example.PatientSystem.model.BookAppointment;
import com.example.PatientSystem.model.Patient;
import com.example.PatientSystem.service.MyUser;
import com.example.PatientSystem.service.PService;
import com.example.PatientSystem.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AppController {

    @Autowired
    private PService patientService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUser myUser;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "addPatient", method = RequestMethod.POST)
    public ResponseEntity<?> addPatient(@RequestParam("email") String email, @RequestParam("name") String name, @RequestParam("address") String address,
                              @RequestParam("mobileNumber") long mobileNumber, @RequestParam("password") String password){
        Patient patient1 = new Patient(email, name, address,mobileNumber, password);
        return ResponseEntity.ok(myUser.save(patient1));
    }

    @RequestMapping(value = "deletePatient", method = RequestMethod.DELETE)
    public boolean deletePatient(@RequestParam String email){
        return patientService.deletePatient(email);
    }

    @RequestMapping(value = "updatePatient", method = RequestMethod.PUT)
    public boolean updatePatient(@RequestParam("email") String email, @RequestParam("name") String name, @RequestParam("address") String address,
                                 @RequestParam("mobileNumber") long mobileNumber, @RequestParam("password") String password){
        return patientService.updatePatient(new Patient(email, name, address,mobileNumber, password));
    }

    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @RequestMapping(value = "bookAppointment", method = RequestMethod.POST)
    public boolean bookAppointment(@RequestParam("email") String email, @RequestParam("doctorName") String doctorName){
        BookAppointment bookAppointment = new BookAppointment(email,new Date(), doctorName);
        return patientService.bookAppointment(bookAppointment);
    }

    @RequestMapping(value = "allAppointment", method = RequestMethod.GET)
    public List<BookAppointment> getAllBookAppointment(){
        return patientService.getAllBookAppointment();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticateToken(@RequestParam("username") String username,
                                                     @RequestParam("password") String password){
//        new object is created of authhenticate request with user name and password
        AuthenticateRequest authenticateRequest = new AuthenticateRequest(username,password);
        try {
            // username and password are authenticated with usernamepasswordauthenticationtoken
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUsername(), authenticateRequest.getPassword()));
            final UserDetails userDetails = myUser.loadUserByUsername(authenticateRequest.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticateResponse(jwt));
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Invalid Password");
        }
//        userdetilas object is created with the help of myuser object and called defined method
//        jwt is created with jwtUtil class method.
//        return responed is send to back to the browser
        return ResponseEntity.ok("no");
    }
}
