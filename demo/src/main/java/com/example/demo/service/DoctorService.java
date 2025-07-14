package com.example.demo.service;
import com.example.demo.models.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService
{
    @Autowired
    DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors()
    {
        try
        {
            System.out.println("Into Service Layer of Doctor Class with get All doctor");
            return doctorRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor)
    {
        try
        {
            System.out.println("Into Service Layer of Doctor Class for Creating doctor");
            doctorRepository.save(doctor);
            return doctor;
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Doctor Class for get doctor By id: " + id);
            Optional<Doctor> d = doctorRepository.findById(id);
            return d.orElse(null);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Doctor Class for Deleting doctor By id: " + id);
            doctorRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }

    public void updateDoctor(Long id, Doctor doctor)
    {
        try
        {
            System.out.println("Into Service Layer of Doctor Class for Updating doctor by id: " + id);
            Doctor d = getDoctorById(id);
            if(d != null)
            {
                d.setName(doctor.getName());
                d.setSpeciality(doctor.getSpeciality());
                doctorRepository.save(d);
            }
            else
            {
                System.out.println("Cannot Update the Doctor with id:" + id + " No Doctor Exists with this id!");
            }
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }
}
