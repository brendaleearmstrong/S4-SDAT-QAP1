package com.keyin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoctorTest {

    private Doctor doctor;

    @BeforeEach
    void setUp() {
        doctor = new Doctor("Dr. Smith", "Dermatology");
    }

    @Test
    void testDoctorConstructor() {
        assertEquals("Dr. Smith", doctor.getName());
        assertEquals("Dermatology", doctor.getSpecialization());
    }

    @Test
    void testSetters() {
        doctor.setName("Dr. Johnson");
        doctor.setSpecialization("Cardiology");

        assertEquals("Dr. Johnson", doctor.getName());
        assertEquals("Cardiology", doctor.getSpecialization());
    }

    @Test
    void testToString() {
        String expected = "Doctor{name='Dr. Smith', specialization='Dermatology'}";
        assertEquals(expected, doctor.toString());
    }
}
