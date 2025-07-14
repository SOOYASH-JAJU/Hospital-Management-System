package com.example.demo.controllers;

import com.example.demo.models.Appointment;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController
{
    @Autowired
    private AppointmentService appointmentService;
    @GetMapping
    public List<Appointment> getAllAppointments()
    {
        System.out.println("Fetching all the Appointments");
        return appointmentService.getAllAppointments();
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment)
    {
        System.out.println("Creating Appointment");
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id)
    {
        System.out.println("Fetching Appointment By ID: " + id);
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id)
    {
        System.out.println("Deleting the Appointment By Id: " + id);
        appointmentService.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment)
    {
        System.out.println("Updating the Appointment With Specific Id: " +id);
        appointmentService.updateAppointment(id,appointment);
    }
}
