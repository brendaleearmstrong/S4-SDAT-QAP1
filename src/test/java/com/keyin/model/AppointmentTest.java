package com.keyin.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private Appointment appointment;
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDateTime;

    @BeforeEach
    void setUp() {
        // Create a new Patient and Doctor for the appointment
        patient = new Patient("BR123", "Brenda Armstrong", "555-1234", "brenda@example.com");
        doctor = new Doctor("Dr. Smith", "Dermatology");

        // Set the appointment date and time to the current date and time
        appointmentDateTime = LocalDateTime.now();

        // Create a new Appointment using the above details
        appointment = new Appointment(patient, doctor, AppointmentType.CONSULTATION, appointmentDateTime);
    }

    @Test
    void testAppointmentConstructor() {
        // Verify that the appointment was created with the correct values
        assertEquals("Brenda Armstrong", appointment.getPatient().getName());
        assertEquals("Dr. Smith", appointment.getDoctor().getName());
        assertEquals(AppointmentType.CONSULTATION, appointment.getType());
        assertEquals(appointmentDateTime, appointment.getDateTime());
    }

    @Test
    void testGetters() {
        // Verify that the getters return the correct values
        assertEquals(patient, appointment.getPatient());
        assertEquals(doctor, appointment.getDoctor());
        assertEquals(AppointmentType.CONSULTATION, appointment.getType());
        assertEquals(appointmentDateTime, appointment.getDateTime());
    }

    @Test
    void testToString() {
        // Test the toString method for the appointment
        String expectedString = "Appointment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", type=" + AppointmentType.CONSULTATION +
                ", dateTime=" + appointmentDateTime +
                '}';

        assertEquals(expectedString, appointment.toString());
    }

    @Test
    void testAppointmentType() {
        // Test that the AppointmentType is correctly set and can be changed if necessary
        appointment = new Appointment(patient, doctor, AppointmentType.FOLLOW_UP, appointmentDateTime);
        assertEquals(AppointmentType.FOLLOW_UP, appointment.getType());
    }
}
