package com.smartcare.clinic.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorId;

    @NotBlank
    @Column(nullable = false)
    private String fullName;

    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String speciality;

    private String phone;

    private LocalTime availableFrom;

    private LocalTime availableTo;

    private LocalDateTime createdAt;

    public Doctor() {
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalTime getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalTime getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalTime availableTo) {
        this.availableTo = availableTo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
