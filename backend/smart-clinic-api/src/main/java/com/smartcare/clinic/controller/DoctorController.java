package com.smartcare.clinic.controller;

import com.smartcare.clinic.entity.Doctor;
import com.smartcare.clinic.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/speciality/{speciality}")
    public List<Doctor> getDoctorsBySpeciality(@PathVariable String speciality) {
        return doctorService.getDoctorsBySpeciality(speciality);
    }
@GetMapping("/search")
public List<Doctor> searchDoctors(
        @RequestParam String speciality,
        @RequestParam String time
) {
    LocalTime t = LocalTime.parse(time);
    return doctorService.getDoctorsBySpecialityAndTime(speciality, t);
}

}
