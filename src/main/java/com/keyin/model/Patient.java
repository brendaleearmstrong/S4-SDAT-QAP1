package com.keyin.model;

public class Patient {

    private String medicalId;
    private String name;
    private String phone;
    private String email;

    // Constructor
    public Patient(String medicalId, String name, String phone, String email) {
        this.medicalId = medicalId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getter for medical ID
    public String getMedicalId() {
        return medicalId;
    }

    // Setter for medical ID
    public void setMedicalId(String medicalId) {
        this.medicalId = medicalId;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for phone
    public String getPhone() {
        return phone;
    }

    // Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override
    public String toString() {
        return "Patient{" +
                "medicalId='" + medicalId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
