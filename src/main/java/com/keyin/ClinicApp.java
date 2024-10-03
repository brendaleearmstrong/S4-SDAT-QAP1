package com.keyin;

import com.keyin.model.Appointment;
import com.keyin.model.AppointmentType;
import com.keyin.model.Doctor;
import com.keyin.model.Patient;
import com.keyin.service.AppointmentService;
import com.keyin.service.DoctorService;
import com.keyin.service.PatientService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ClinicApp {

    private static final PatientService patientService = new PatientService();
    private static final DoctorService doctorService = new DoctorService();
    private static final AppointmentService appointmentService = new AppointmentService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the SMOOTH HEALTH Medical Esthetics Clinic Management System");

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1 -> managePatients();
                case 2 -> manageDoctors();
                case 3 -> manageAppointments();
                case 4 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using SMOOTH HEALTH Clinic System. Goodbye!");
    }

    // Print the main menu options
    private static void printMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Manage Patients");
        System.out.println("2. Manage Doctors");
        System.out.println("3. Manage Appointments");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Get the user input as a menu choice
    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();  // Consume invalid input
        }
        return scanner.nextInt();
    }

    // Manage Patients - Add, View, Find
    private static void managePatients() {
        System.out.println("\n--- Manage Patients ---");
        System.out.println("1. Add a new patient");
        System.out.println("2. View all patients");
        System.out.println("3. Find a patient");
        System.out.print("Enter your choice: ");
        int choice = getUserChoice();
        switch (choice) {
            case 1 -> addNewPatient();
            case 2 -> viewAllPatients();
            case 3 -> findPatient();
            default -> System.out.println("Invalid choice.");
        }
    }

    // Add a new patient
    private static void addNewPatient() {
        scanner.nextLine(); // Consume newline
        System.out.println("Enter patient details:");
        System.out.print("Medical ID Number: ");
        String medicalId = scanner.nextLine();  // Ensure Medical ID is collected
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Correct the constructor to pass four arguments: Medical ID, Name, Phone, and Email
        Patient patient = new Patient(medicalId, name, phone, email);
        patientService.addPatient(patient);
        System.out.println("Patient added successfully!");
    }

    // View all patients
    private static void viewAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            patients.forEach(patient -> System.out.println(patient));
        }
    }

    // Find a patient by name or phone number
    private static void findPatient() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter patient name or phone number: ");
        String search = scanner.nextLine();
        List<Patient> patients = patientService.findPatients(search);
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            patients.forEach(patient -> System.out.println(patient));
        }
    }

    // Manage Doctors - Add, View
    private static void manageDoctors() {
        System.out.println("\n--- Manage Doctors ---");
        System.out.println("1. Add a new doctor");
        System.out.println("2. View all doctors");
        System.out.print("Enter your choice: ");
        int choice = getUserChoice();
        switch (choice) {
            case 1 -> addNewDoctor();
            case 2 -> viewAllDoctors();
            default -> System.out.println("Invalid choice.");
        }
    }

    // Add a new doctor
    private static void addNewDoctor() {
        scanner.nextLine(); // Consume newline
        System.out.println("Enter doctor details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(name, specialization);
        doctorService.addDoctor(doctor);
        System.out.println("Doctor added successfully!");
    }

    // View all doctors
    private static void viewAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            doctors.forEach(doctor -> System.out.println(doctor));
        }
    }

    // Manage Appointments - Schedule, View
    private static void manageAppointments() {
        System.out.println("\n--- Manage Appointments ---");
        System.out.println("1. Schedule a new appointment");
        System.out.println("2. View all appointments");
        System.out.print("Enter your choice: ");
        int choice = getUserChoice();
        switch (choice) {
            case 1 -> scheduleNewAppointment();
            case 2 -> viewAllAppointments();
            default -> System.out.println("Invalid choice.");
        }
    }

    // Schedule a new appointment
    private static void scheduleNewAppointment() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter patient's name: ");
        String patientName = scanner.nextLine();
        Patient patient = patientService.findPatientByName(patientName);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Enter doctor's name: ");
        String doctorName = scanner.nextLine();
        Doctor doctor = doctorService.findDoctorByName(doctorName);
        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.println("Select appointment type:");
        for (int i = 0; i < AppointmentType.values().length; i++) {
            System.out.println((i + 1) + ". " + AppointmentType.values()[i]);
        }
        int typeChoice = getUserChoice() - 1;
        if (typeChoice < 0 || typeChoice >= AppointmentType.values().length) {
            System.out.println("Invalid choice.");
            return;
        }
        AppointmentType appointmentType = AppointmentType.values()[typeChoice];

        // Prompt for the appointment date and time with error handling
        LocalDateTime appointmentDateTime = null;
        while (appointmentDateTime == null) {
            System.out.println("Enter appointment date and time (format: yyyy-MM-dd HH:mm): ");
            String dateTimeString = scanner.nextLine();
            try {
                appointmentDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            } catch (Exception e) {
                System.out.println("Invalid date format. Please try again.");
            }
        }

        Appointment appointment = new Appointment(patient, doctor, appointmentType, appointmentDateTime);
        appointmentService.addAppointment(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    // View all appointments
    private static void viewAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointments();
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            appointments.forEach(appointment -> System.out.println(appointment));
        }
    }
}
