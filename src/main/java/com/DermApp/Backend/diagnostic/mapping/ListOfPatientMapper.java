package com.DermApp.Backend.diagnostic.mapping;

import com.DermApp.Backend.diagnostic.domain.model.entity.ListOfPatient;
import com.DermApp.Backend.diagnostic.domain.model.entity.Patient;
import com.DermApp.Backend.diagnostic.resource.CreatePatientResource;
import com.DermApp.Backend.diagnostic.resource.ListOfPatientResource;
import com.DermApp.Backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class ListOfPatientMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ListOfPatientResource toResource(ListOfPatient model){
        return mapper.map(model, ListOfPatientResource.class);
    }

    public Patient toModel(CreatePatientResource resource){
        return mapper.map(resource, Patient.class);
    }
}
