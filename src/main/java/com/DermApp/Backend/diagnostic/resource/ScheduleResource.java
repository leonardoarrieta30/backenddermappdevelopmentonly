package com.DermApp.Backend.diagnostic.resource;

import com.DermApp.Backend.diagnostic.domain.model.entity.Patient;

import java.util.HashSet;
import java.util.Set;

public class ScheduleResource {
    private Long id;
    private String name;
    private String toDo;
    private Set<Patient> patients = new HashSet<>();
}
