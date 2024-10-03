package com.keyin.model;

public class Doctor {

    private String name;
    private String specialization;

    // Constructor
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for specialization
    public String getSpecialization() {
        return specialization;
    }

    // Setter for specialization
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString method
    @Override
    public String toString() {
        return "Doctor{name='" + name + '\'' + ", specialization='" + specialization + '\'' + '}';
    }
}
