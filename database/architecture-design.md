# Smart Clinic Management System
Architecture Design Document

## 1. System Overview

The Smart Clinic Management System is a web based application developed to manage doctors, patients, appointments and prescriptions for outpatient clinics. The system is built using a microservice oriented architecture with a Spring Boot backend and a browser based frontend.

The application provides secure role based access for Admin, Doctor and Patient users.

## 2. Architecture Style

The system follows a layered and REST based microservice architecture.

Frontend communicates with backend services using REST APIs secured with JWT authentication.

## 3. High Level Architecture

Frontend
HTML, CSS and JavaScript based user interface.

Backend
Spring Boot REST services.

Database Layer
MySQL for structured relational data.
MongoDB for unstructured prescription data.

## 4. Major Components

Frontend Application
Admin portal
Doctor portal
Patient portal

Backend Services
Authentication and authorization service
Doctor management service
Patient management service
Appointment management service
Prescription management service

Databases
MySQL database
MongoDB database

## 5. Technology Stack

Frontend
HTML
CSS
JavaScript

Backend
Java 17
Spring Boot
Spring Data JPA
Spring Security
JWT

Databases
MySQL
MongoDB

DevOps
Docker
GitHub Actions

## 6. Microservices Identification

Doctor Service
Manages doctor profiles and availability

Patient Service
Manages patient records

Appointment Service
Handles appointment scheduling and reporting

Prescription Service
Stores and retrieves prescription data from MongoDB

Authentication Service
Handles login and JWT token generation
