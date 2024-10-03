package com.keyin.service;

import com.keyin.model.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {

    private DoctorService doctorService;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        doctorService = new DoctorService();

        // Creating a Doctor object
        doctor = new Doctor("Dr. Smith", "Dermatology");
    }

    @Test
    void testAddDoctor() {
        // Add doctor to the service
        doctorService.addDoctor(doctor);
        List<Doctor> doctors = doctorService.getAllDoctors();

        // Check that the doctor is added
        assertEquals(1, doctors.size());
        assertEquals("Dr. Smith", doctors.get(0).getName());
    }

    @Test
    void testGetAllDoctors() {
        // Add doctor to the service
        doctorService.addDoctor(doctor);

        // Check that the correct doctor list is returned
        List<Doctor> doctors = doctorService.getAllDoctors();
        assertFalse(doctors.isEmpty());
        assertEquals(1, doctors.size());
    }

    @Test
    void testFindDoctorByName() {
        // Add doctor to the service
        doctorService.addDoctor(doctor);

        // Find the doctor by name
        Doctor foundDoctor = doctorService.findDoctorByName("Dr. Smith");
        assertNotNull(foundDoctor);
        assertEquals("Dr. Smith", foundDoctor.getName());
    }
}
