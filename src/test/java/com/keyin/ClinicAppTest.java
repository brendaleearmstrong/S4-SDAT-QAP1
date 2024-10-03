package com.keyin;

import com.keyin.model.Appointment;
import com.keyin.model.AppointmentType;
import com.keyin.model.Doctor;
import com.keyin.model.Patient;
import com.keyin.service.AppointmentService;
import com.keyin.service.DoctorService;
import com.keyin.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClinicAppTest {

    private PatientService patientService;
    private DoctorService doctorService;
    private AppointmentService appointmentService;
    private Patient patient;
    private Doctor doctor;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        patientService = new PatientService();
        doctorService = new DoctorService();
        appointmentService = new AppointmentService();

        // Use your name for the patient in the test
        patient = new Patient("BR123", "Brenda Armstrong", "555-1234", "brenda@example.com");
        doctor = new Doctor("Dr. Smith", "Dermatology");
        LocalDateTime appointmentDateTime = LocalDateTime.now();
        appointment = new Appointment(patient, doctor, AppointmentType.CONSULTATION, appointmentDateTime);
    }

    @Test
    void testAddNewPatient() {
        patientService.addPatient(patient);
        List<Patient> patients = patientService.getAllPatients();
        assertEquals(1, patients.size());
        assertEquals("Brenda Armstrong", patients.get(0).getName());
    }

    @Test
    void testFindPatient() {
        patientService.addPatient(patient);
        List<Patient> foundPatients = patientService.findPatients("Brenda Armstrong");
        assertEquals(1, foundPatients.size());
        assertEquals("BR123", foundPatients.get(0).getMedicalId());
    }

    @Test
    void testAddDoctor() {
        doctorService.addDoctor(doctor);
        List<Doctor> doctors = doctorService.getAllDoctors();
        assertEquals(1, doctors.size());
        assertEquals("Dr. Smith", doctors.get(0).getName());
    }

    @Test
    void testScheduleAppointment() {
        appointmentService.addAppointment(appointment);
        List<Appointment> appointments = appointmentService.getAllAppointments();
        assertEquals(1, appointments.size());
        assertEquals("Brenda Armstrong", appointments.get(0).getPatient().getName());
        assertEquals("Dr. Smith", appointments.get(0).getDoctor().getName());
    }

    @Test
    void testViewAllAppointments() {
        appointmentService.addAppointment(appointment);
        List<Appointment> appointments = appointmentService.getAllAppointments();
        assertFalse(appointments.isEmpty());
        assertEquals("Brenda Armstrong", appointments.get(0).getPatient().getName());
    }

    @Test
    void testDoctorSpecialization() {
        doctorService.addDoctor(doctor);
        List<Doctor> doctors = doctorService.getAllDoctors();
        assertEquals("Dermatology", doctors.get(0).getSpecialization());
    }
}
