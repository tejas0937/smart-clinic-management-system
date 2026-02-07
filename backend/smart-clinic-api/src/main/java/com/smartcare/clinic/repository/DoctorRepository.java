package com.smartcare.clinic.repository;

import com.smartcare.clinic.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findBySpeciality(String speciality);

    List<Doctor> findBySpecialityAndAvailableFromLessThanEqualAndAvailableToGreaterThanEqual(
            String speciality,
            LocalTime time1,
            LocalTime time2
    );

}
