package com.example.demo.service;
import com.example.demo.models.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService
{
    @Autowired
    private PatientRepository patientRepository;
    public List<Patient> getAllPatients()
    {
       try
       {
           System.out.println("Into Service Layer of Patient Class with get All patient");
           return patientRepository.findAll();
       } catch (Exception e) {
           System.out.println("Error Message: " + e.getMessage());
           return null;
       }
    }

    public Patient createPatient(Patient patient)
    {
        try
        {
            System.out.println("Into Service Layer of Patient Class for Creating patient");
            patientRepository.save(patient);
            return patient;
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Patient Class for get Patient By id: " + id);
            Optional<Patient> patient= patientRepository.findById(id);
            return patient.orElse(null);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id)
    {
        try
        {
            System.out.println("Into Service Layer of Patient Class for Deleting patient By id: " + id);
            patientRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }

    public void updatePatient(Long id,Patient patient)
    {
        try
        {
            System.out.println("Into Service Layer of Patient Class for Updating patient by id: " + id);
            //Update ke liyeh pehle get kro fir update krna
            Optional<Patient> existingPatient = patientRepository.findById(id);
            if(existingPatient.isPresent())
            {
                Patient p = existingPatient.get();
                p.setName(patient.getName());
                p.setGender(patient.getGender());
                p.setAge(patient.getAge());
                patientRepository.save(p);
            }
            else
            {
                System.out.println("Patient Does Not Exists for which you want to update with id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error Message: " + e.getMessage());
        }
    }
}
