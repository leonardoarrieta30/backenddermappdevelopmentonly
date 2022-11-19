package com.DermApp.Backend.diagnostic.domain.persistence;

import com.DermApp.Backend.diagnostic.domain.model.entity.ListOfPatient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOfPatientRepository extends JpaRepository<ListOfPatient, Long> {
    ListOfPatient findAllPatientsById(Long patientId);
}
