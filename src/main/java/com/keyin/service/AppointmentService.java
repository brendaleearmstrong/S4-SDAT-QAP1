package com.keyin.service;

import com.keyin.model.Appointment;
import com.keyin.model.Patient;
import com.keyin.model.Doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    // Add a new appointment to the list
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    // Retrieve all appointments
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Find appointments by patient name
    public List<Appointment> findAppointmentsByPatientName(String patientName) {
        return appointments.stream()
                .filter(appointment -> appointment.getPatient().getName().equalsIgnoreCase(patientName))
                .collect(Collectors.toList());
    }

    // Find appointments by doctor name
    public List<Appointment> findAppointmentsByDoctorName(String doctorName) {
        return appointments.stream()
                .filter(appointment -> appointment.getDoctor().getName().equalsIgnoreCase(doctorName))
                .collect(Collectors.toList());
    }

    // Find appointments by both patient and doctor names
    public List<Appointment> findAppointmentsByPatientAndDoctor(String patientName, String doctorName) {
        return appointments.stream()
                .filter(appointment -> appointment.getPatient().getName().equalsIgnoreCase(patientName) &&
                        appointment.getDoctor().getName().equalsIgnoreCase(doctorName))
                .collect(Collectors.toList());
    }

    // Cancel an appointment by removing it from the list
    public boolean cancelAppointment(Appointment appointment) {
        return appointments.remove(appointment);
    }

    // Find a specific appointment by patient and date
    public Appointment findAppointmentByPatientAndDate(Patient patient, String date) {
        return appointments.stream()
                .filter(appointment -> appointment.getPatient().getName().equalsIgnoreCase(patient.getName()) &&
                        appointment.getDateTime().toString().contains(date))
                .findFirst()
                .orElse(null);
    }

    // Find an appointment by patient and doctor names and date
    public Appointment findAppointmentByPatientDoctorAndDate(String patientName, String doctorName, String date) {
        return appointments.stream()
                .filter(appointment -> appointment.getPatient().getName().equalsIgnoreCase(patientName) &&
                        appointment.getDoctor().getName().equalsIgnoreCase(doctorName) &&
                        appointment.getDateTime().toString().contains(date))
                .findFirst()
                .orElse(null);
    }
}
