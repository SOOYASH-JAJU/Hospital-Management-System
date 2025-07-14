package com.example.demo.controllers;
import com.example.demo.models.Doctor;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController
{
    @Autowired
    DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors()
    {
        System.out.println("Fetching all the Doctors");
        return doctorService.getAllDoctors();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor)
    {
        System.out.println("Creating Doctor");
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id)
    {
        System.out.println("Fetching Doctor By ID: " + id);
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id)
    {
        System.out.println("Deleting the Doctor By Id: " + id);
        doctorService.deleteDoctor(id);
    }

    @PutMapping("/{id}")
    public void updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor)
    {
        System.out.println("Updating the Doctor With Specific Id: " + id);
        doctorService.updateDoctor(id, doctor);
    }
}
