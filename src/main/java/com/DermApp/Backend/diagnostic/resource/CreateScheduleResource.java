package com.DermApp.Backend.diagnostic.resource;

import javax.validation.constraints.Size;

public class CreateScheduleResource {
    @Size(max = 50)
    private String name;

    private String toDo;
}
