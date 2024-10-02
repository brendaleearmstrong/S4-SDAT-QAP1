package com.keyin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientTest {

    private Patient patient;

    @BeforeEach
    void setUp() {
        // Set up a new Patient object before each test
        patient = new Patient("John Doe", "555-1234", "john@example.com");
    }

    @Test
    void testPatientConstructor() {
        // Test the constructor by asserting the initial values
        assertEquals("John Doe", patient.getName(), "The patient's name should be John Doe.");
        assertEquals("555-1234", patient.getPhone(), "The patient's phone should be 555-1234.");
        assertEquals("john@example.com", patient.getEmail(), "The patient's email should be john@example.com.");
    }

    @Test
    void testGetters() {
        // Test that the getters return the correct values
        assertEquals("John Doe", patient.getName(), "The name getter should return John Doe.");
        assertEquals("555-1234", patient.getPhone(), "The phone getter should return 555-1234.");
        assertEquals("john@example.com", patient.getEmail(), "The email getter should return john@example.com.");
    }

    @Test
    void testSetters() {
        // Test setting new values using the setters
        patient.setName("Jane Doe");
        patient.setPhone("555-5678");
        patient.setEmail("jane@example.com");

        // Assert that the values have been updated
        assertEquals("Jane Doe", patient.getName(), "The name should be updated to Jane Doe.");
        assertEquals("555-5678", patient.getPhone(), "The phone should be updated to 555-5678.");
        assertEquals("jane@example.com", patient.getEmail(), "The email should be updated to jane@example.com.");
    }

    @Test
    void testToString() {
        // Test the toString method
        String expected = "Patient{name='John Doe', phone='555-1234', email='john@example.com'}";
        assertEquals(expected, patient.toString(), "The toString method should return the correct string representation.");
    }
}
