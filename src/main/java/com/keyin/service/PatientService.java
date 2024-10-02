package com.keyin.service;

import com.keyin.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PatientService {
    private List<Patient> patients = new ArrayList<>();

    // Add a new patient to the list
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Retrieve all patients
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Find patients by name or phone number
    public List<Patient> findPatients(String search) {
        return patients.stream()
                .filter(patient -> patient.getName().equalsIgnoreCase(search) || patient.getPhone().equalsIgnoreCase(search))
                .collect(Collectors.toList());
    }

    // Find a specific patient by name
    public Patient findPatientByName(String name) {
        return patients.stream()
                .filter(patient -> patient.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
