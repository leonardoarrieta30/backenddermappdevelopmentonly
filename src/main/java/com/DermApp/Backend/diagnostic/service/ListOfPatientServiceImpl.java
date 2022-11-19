package com.DermApp.Backend.diagnostic.service;


import com.DermApp.Backend.diagnostic.domain.model.entity.Patient;
import com.DermApp.Backend.diagnostic.domain.persistence.PatientRepository;
import com.DermApp.Backend.diagnostic.domain.service.ListOfPatientService;
import com.DermApp.Backend.shared.exception.ResourceNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ListOfPatientServiceImpl implements ListOfPatientService {
    private static final String ENTITY = "Patient";
    private final PatientRepository patientRepository;

    public ListOfPatientServiceImpl(PatientRepository patientRepository, Validator validator) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Page<Patient> getAll(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    @Override
    public Patient getById(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,patientId));
    }

}
