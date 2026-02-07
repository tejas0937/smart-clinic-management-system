package com.smartcare.clinic.mongo.repository;

import com.smartcare.clinic.mongo.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrescriptionRepository extends MongoRepository<Prescription, String> {

    List<Prescription> findByPatientId(Long patientId);

}
