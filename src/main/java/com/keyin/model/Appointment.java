package com.keyin.model;

import java.time.LocalDateTime;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private AppointmentType type;
    private LocalDateTime dateTime;

    public Appointment(Patient patient, Doctor doctor, AppointmentType type, LocalDateTime dateTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.type = type;
        this.dateTime = dateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public AppointmentType getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", type=" + type +
                ", dateTime=" + dateTime +
                '}';
    }
}
