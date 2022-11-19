package com.DermApp.Backend.diagnostic.resource;

import com.DermApp.Backend.diagnostic.domain.model.entity.Patient;

import javax.validation.constraints.Size;

public class UpdateScheduleResource {
    private Long id;

    @Size(max = 50)
    private String name;

    private String toDo;

    private Patient patient;
}
