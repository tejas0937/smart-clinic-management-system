# Smart Clinic Management System
MySQL Schema Design

## Database Name
smart_clinic_db

## Tables

### 1. admin

admin_id BIGINT PRIMARY KEY AUTO_INCREMENT  
username VARCHAR(100) NOT NULL UNIQUE  
password VARCHAR(255) NOT NULL  
email VARCHAR(150) NOT NULL  
created_at TIMESTAMP

---

### 2. doctor

doctor_id BIGINT PRIMARY KEY AUTO_INCREMENT  
full_name VARCHAR(150) NOT NULL  
email VARCHAR(150) UNIQUE  
speciality VARCHAR(100) NOT NULL  
phone VARCHAR(20)  
available_from TIME  
available_to TIME  
created_at TIMESTAMP

---

### 3. patient

patient_id BIGINT PRIMARY KEY AUTO_INCREMENT  
full_name VARCHAR(150) NOT NULL  
email VARCHAR(150) UNIQUE  
phone VARCHAR(20)  
date_of_birth DATE  
created_at TIMESTAMP

---

### 4. appointment

appointment_id BIGINT PRIMARY KEY AUTO_INCREMENT  
appointment_date DATE NOT NULL  
appointment_time TIME NOT NULL  
status VARCHAR(50)

doctor_id BIGINT  
patient_id BIGINT  

FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)  
FOREIGN KEY (patient_id) REFERENCES patient(patient_id)

---

## MongoDB Collection

### prescription

Prescription data is stored in MongoDB because the structure can vary.

Fields

_id  
appointmentId  
doctorId  
patientId  
medications  
notes  
createdAt
