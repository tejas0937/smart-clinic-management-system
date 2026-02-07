package com.smartcare.clinic.service;

import com.smartcare.clinic.entity.Doctor;
import com.smartcare.clinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ArrayList;     
import java.time.LocalTime;
import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<String> getDoctorAvailability(Long doctorId, LocalDate date) {

    List<String> slots = new ArrayList<>();

    slots.add("09:00 - 09:30");
    slots.add("09:30 - 10:00");
    slots.add("10:00 - 10:30");

    return slots;
}
public boolean validateDoctorLogin(String email) {
    return doctorRepository.findAll()
            .stream()
            .anyMatch(d -> d.getEmail() != null && d.getEmail().equals(email));
}

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public List<Doctor> getDoctorsBySpeciality(String speciality) {
        return doctorRepository.findBySpeciality(speciality);
    }
public List<Doctor> getDoctorsBySpecialityAndTime(String speciality, LocalTime time) {
    return doctorRepository
            .findBySpecialityAndAvailableFromLessThanEqualAndAvailableToGreaterThanEqual(
                    speciality, time, time
            );
}

}
