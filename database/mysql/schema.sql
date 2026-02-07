CREATE DATABASE IF NOT EXISTS smart_clinic_db;
USE smart_clinic_db;

DROP TABLE IF EXISTS appointment;
DROP TABLE IF EXISTS patient;
DROP TABLE IF EXISTS doctor;
DROP TABLE IF EXISTS admin;

CREATE TABLE admin (
    admin_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(150) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE doctor (
    doctor_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) UNIQUE,
    speciality VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    available_from TIME,
    available_to TIME,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patient (
    patient_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(150) NOT NULL,
    email VARCHAR(150) UNIQUE,
    phone VARCHAR(20),
    date_of_birth DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE appointment (
    appointment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status VARCHAR(50),
    doctor_id BIGINT,
    patient_id BIGINT,
    CONSTRAINT fk_appointment_doctor FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id),
    CONSTRAINT fk_appointment_patient FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);

-- ----------------------------
-- Sample data
-- ----------------------------

INSERT INTO admin (username,password,email)
VALUES
('admin1','admin123','admin1@smartcare.com');

INSERT INTO doctor (full_name,email,speciality,phone,available_from,available_to)
VALUES
('Dr. Amit Shah','amit@clinic.com','Cardiology','9999990001','09:00:00','13:00:00'),
('Dr. Neha Patil','neha@clinic.com','Dermatology','9999990002','10:00:00','14:00:00'),
('Dr. Rahul Joshi','rahul@clinic.com','Orthopedics','9999990003','11:00:00','15:00:00');

INSERT INTO patient (full_name,email,phone,date_of_birth)
VALUES
('Rohit Kulkarni','rohit@gmail.com','8888881111','1999-01-12'),
('Sneha Deshmukh','sneha@gmail.com','8888882222','1998-05-20'),
('Amit Pawar','amitp@gmail.com','8888883333','2000-03-18'),
('Pooja Patil','pooja@gmail.com','8888884444','2001-07-25'),
('Kiran Jadhav','kiran@gmail.com','8888885555','1997-09-30'),
('Anita More','anita@gmail.com','8888886666','1996-11-11');

INSERT INTO appointment (appointment_date,appointment_time,status,doctor_id,patient_id)
VALUES
('2026-02-10','09:30:00','BOOKED',1,1),
('2026-02-10','10:30:00','BOOKED',1,2),
('2026-02-10','11:30:00','BOOKED',2,3),
('2026-02-11','12:00:00','BOOKED',2,4),
('2026-03-05','10:00:00','BOOKED',3,5),
('2026-03-07','11:00:00','BOOKED',3,6);

-- ----------------------------
-- Stored Procedures
-- ----------------------------

DELIMITER $$

CREATE PROCEDURE GetDailyAppointmentReportByDoctor(IN p_doctor_id BIGINT, IN p_date DATE)
BEGIN
    SELECT
        d.full_name AS doctor_name,
        a.appointment_date,
        a.appointment_time,
        p.full_name AS patient_name,
        a.status
    FROM appointment a
    JOIN doctor d ON a.doctor_id = d.doctor_id
    JOIN patient p ON a.patient_id = p.patient_id
    WHERE a.doctor_id = p_doctor_id
      AND a.appointment_date = p_date
    ORDER BY a.appointment_time;
END$$

CREATE PROCEDURE GetDoctorWithMostPatientsByMonth(IN p_month INT, IN p_year INT)
BEGIN
    SELECT
        d.doctor_id,
        d.full_name,
        COUNT(a.patient_id) AS total_patients
    FROM appointment a
    JOIN doctor d ON a.doctor_id = d.doctor_id
    WHERE MONTH(a.appointment_date) = p_month
      AND YEAR(a.appointment_date) = p_year
    GROUP BY d.doctor_id, d.full_name
    ORDER BY total_patients DESC
    LIMIT 1;
END$$

CREATE PROCEDURE GetDoctorWithMostPatientsByYear(IN p_year INT)
BEGIN
    SELECT
        d.doctor_id,
        d.full_name,
        COUNT(a.patient_id) AS total_patients
    FROM appointment a
    JOIN doctor d ON a.doctor_id = d.doctor_id
    WHERE YEAR(a.appointment_date) = p_year
    GROUP BY d.doctor_id, d.full_name
    ORDER BY total_patients DESC
    LIMIT 1;
END$$

DELIMITER ;
