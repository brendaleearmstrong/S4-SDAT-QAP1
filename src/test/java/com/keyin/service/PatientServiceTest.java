package com.keyin.service;

import com.keyin.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {

    private PatientService patientService;
    private Patient patient;

    @BeforeEach
    void setUp() {
        patientService = new PatientService();

        // Creating a Patient object
        patient = new Patient("BR123", "Brenda Armstrong", "555-1234", "brenda@example.com");
    }

    @Test
    void testAddPatient() {
        // Add patient to the service
        patientService.addPatient(patient);
        List<Patient> patients = patientService.getAllPatients();

        // Check that the patient is added
        assertEquals(1, patients.size());
        assertEquals("Brenda Armstrong", patients.get(0).getName());
    }

    @Test
    void testGetAllPatients() {
        // Add patient to the service
        patientService.addPatient(patient);

        // Check that the correct patient list is returned
        List<Patient> patients = patientService.getAllPatients();
        assertFalse(patients.isEmpty());
        assertEquals(1, patients.size());
    }

    @Test
    void testFindPatients() {
        // Add patient to the service
        patientService.addPatient(patient);

        // Find the patient by name
        List<Patient> foundPatients = patientService.findPatients("Brenda Armstrong");
        assertEquals(1, foundPatients.size());
        assertEquals("BR123", foundPatients.get(0).getMedicalId());
    }
}
