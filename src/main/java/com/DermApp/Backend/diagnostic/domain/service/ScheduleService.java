package com.DermApp.Backend.diagnostic.domain.service;

import com.DermApp.Backend.diagnostic.domain.model.entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleService {

    List<Schedule> getAll();
    Page<Schedule> getAll(Pageable pageable);
    Schedule getById(Long scheduleId);
    Schedule create(Schedule schedule);
    Schedule update(Long scheduleId, Schedule request);
    ResponseEntity<?> delete(Long scheduleId);

}
