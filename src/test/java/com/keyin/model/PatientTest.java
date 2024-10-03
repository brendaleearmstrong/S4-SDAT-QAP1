package com.keyin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient patient;

    @BeforeEach
    void setUp() {
        // Set up a new Patient object before each test, now with Medical ID included
        patient = new Patient("MID123", "John Doe", "555-1234", "john@example.com");
    }

    @Test
    void testPatientConstructor() {
        // Test the constructor by asserting the initial values, including Medical ID
        assertEquals("MID123", patient.getMedicalId(), "The patient's Medical ID should be MID123.");
        assertEquals("John Doe", patient.getName(), "The patient's name should be John Doe.");
        assertEquals("555-1234", patient.getPhone(), "The patient's phone should be 555-1234.");
        assertEquals("john@example.com", patient.getEmail(), "The patient's email should be john@example.com.");
    }

    @Test
    void testGetters() {
        // Test that the getters return the correct values, including Medical ID
        assertEquals("MID123", patient.getMedicalId(), "The Medical ID getter should return MID123.");
        assertEquals("John Doe", patient.getName(), "The name getter should return John Doe.");
        assertEquals("555-1234", patient.getPhone(), "The phone getter should return 555-1234.");
        assertEquals("john@example.com", patient.getEmail(), "The email getter should return john@example.com.");
    }

    @Test
    void testSetters() {
        // Test setting new values using the setters, including Medical ID
        patient.setMedicalId("MID456");
        patient.setName("Jane Doe");
        patient.setPhone("555-5678");
        patient.setEmail("jane@example.com");

        // Assert that the values have been updated
        assertEquals("MID456", patient.getMedicalId(), "The Medical ID should be updated to MID456.");
        assertEquals("Jane Doe", patient.getName(), "The name should be updated to Jane Doe.");
        assertEquals("555-5678", patient.getPhone(), "The phone should be updated to 555-5678.");
        assertEquals("jane@example.com", patient.getEmail(), "The email should be updated to jane@example.com.");
    }

    @Test
    void testToString() {
        // Test the toString method, now including Medical ID in the string representation
        String expected = "Patient{medicalId='MID123', name='John Doe', phone='555-1234', email='john@example.com'}";
        assertEquals(expected, patient.toString(), "The toString method should return the correct string representation.");
    }
}
