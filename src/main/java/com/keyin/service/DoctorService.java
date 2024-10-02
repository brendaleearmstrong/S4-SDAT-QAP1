package com.keyin.service;

import com.keyin.model.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    // Add a new doctor to the list
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Retrieve all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Find doctors by name
    public List<Doctor> findDoctors(String search) {
        return doctors.stream()
                .filter(doctor -> doctor.getName().equalsIgnoreCase(search))
                .collect(Collectors.toList());
    }

    // Find a doctor by name
    public Doctor findDoctorByName(String name) {
        return doctors.stream()
                .filter(doctor -> doctor.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
