package com.DermApp.Backend.diagnostic.mapping;

import com.DermApp.Backend.diagnostic.domain.model.entity.Patient;
import com.DermApp.Backend.diagnostic.domain.model.entity.Schedule;
import com.DermApp.Backend.diagnostic.resource.*;
import com.DermApp.Backend.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ScheduleMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public ScheduleResource toResource(Schedule model){
        return mapper.map(model, ScheduleResource.class);
    }

    public Schedule toModel(CreateScheduleResource resource){
        return mapper.map(resource, Schedule.class);
    }

    public Schedule toModel(UpdateScheduleResource resource){
        return mapper.map(resource, Schedule.class);
    }

    //show a list patients
    public Page<PatientResource> modelListPage(List<Patient> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, PatientResource.class), pageable, modelList.size());
    }
}
