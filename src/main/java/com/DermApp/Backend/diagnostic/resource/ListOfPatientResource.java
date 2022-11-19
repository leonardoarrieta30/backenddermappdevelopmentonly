package com.DermApp.Backend.diagnostic.resource;

import com.DermApp.Backend.diagnostic.domain.model.entity.Dermatologist;
import com.DermApp.Backend.diagnostic.domain.model.entity.Patient;

import java.util.HashSet;
import java.util.Set;

public class ListOfPatientResource {
    private Long id;
    private Set<Patient> patients = new HashSet<>();
    private Set<Dermatologist> dermatologists = new HashSet<>();
}
