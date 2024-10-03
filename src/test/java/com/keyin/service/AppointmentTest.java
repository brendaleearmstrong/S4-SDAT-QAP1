package com.keyin.service;

import com.keyin.model.Appointment;
import com.keyin.model.AppointmentType;
import com.keyin.model.Doctor;
import com.keyin.model.Patient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {

    private AppointmentService appointmentService;
    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();

        // Create a Patient and Doctor
        patient = new Patient("BR123", "Brenda Armstrong", "555-1234", "brenda@example.com");
        doctor = new Doctor("Dr. Smith", "Dermatology");

        // Create an Appointment
        LocalDateTime appointmentDateTime = LocalDateTime.now();
        appointment = new Appointment(patient, doctor, AppointmentType.CONSULTATION, appointmentDateTime);
    }

    @Test
    void testAddAppointment() {
        // Add appointment to the service
        appointmentService.addAppointment(appointment);
        List<Appointment> appointments = appointmentService.getAllAppointments();

        // Check that the appointment is added
        assertEquals(1, appointments.size());
        assertEquals(patient, appointments.get(0).getPatient());
    }

    @Test
    void testGetAllAppointments() {
        // Add appointment to the service
        appointmentService.addAppointment(appointment);

        // Check that the correct appointment list is returned
        List<Appointment> appointments = appointmentService.getAllAppointments();
        assertFalse(appointments.isEmpty());
        assertEquals(1, appointments.size());
    }
}
