package com.example.demo.service;
import com.example.demo.models.Appointment;
import com.example.demo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService
{
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments()
    {
        try
        {
            System.out.println("Into Service Layer of Appointment Class with get All Appointment");
            return appointmentRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public Appointment createAppointment(Appointment appointment)
    {
        try
        {
            System.out.println("Into Service Layer of Appointment Class for Creating Appointment");
            return appointmentRepository.save(appointment);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Appointment Class for get Appointment By id: " + id);
            Optional<Appointment> appointment = appointmentRepository.findById(id);
            return appointment.orElse(null);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Appointment Class for Deleting Appointment By id: " + id);
            appointmentRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }

    public void updateAppointment(Long id, Appointment appointment)
    {
        try
        {
            //For updating first we have to check whether it exists or not
            Appointment a =  getAppointmentById(id);
            if(a != null)
            {
                a.setPatientId(appointment.getPatientId());
                a.setDoctorId(appointment.getDoctorId());
                a.setDate(appointment.getDate());
                appointmentRepository.save(a);
            }
            else
            {
                System.out.println("Cannot Update Appointment As no appoinment with id: " + id + " Found");
            }

            System.out.println("Into Service Layer of Appointment Class for Updating Appointment by id: " + id);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }
}
