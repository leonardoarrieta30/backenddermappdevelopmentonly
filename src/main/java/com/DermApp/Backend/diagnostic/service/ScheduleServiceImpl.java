package com.DermApp.Backend.diagnostic.service;

import com.DermApp.Backend.diagnostic.domain.model.entity.Schedule;
import com.DermApp.Backend.diagnostic.domain.persistence.ScheduleRepository;
import com.DermApp.Backend.diagnostic.domain.service.ScheduleService;
import com.DermApp.Backend.shared.exception.ResourceNotFoundException;
import com.DermApp.Backend.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private static final String ENTITY = "Patient";
    private final ScheduleRepository scheduleRepository;

    private final Validator validator;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, Validator validator) {
        this.scheduleRepository = scheduleRepository;
        this.validator = validator;
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Page<Schedule> getAll(Pageable pageable) {
        return scheduleRepository.findAll(pageable);
    }

    @Override
    public Schedule getById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, scheduleId));
    }

    @Override
    public Schedule create(Schedule schedule) {
        Set<ConstraintViolation<Schedule>> violations = validator.validate(schedule);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Schedule scheduleWithName = scheduleRepository.findByName(schedule.getName());

        if(scheduleWithName!= null)
            throw new ResourceValidationException(ENTITY,
                    "The name of the day already exists.");

        //There is no constraint to do

        return scheduleRepository.save(schedule);

    }

    @Override
    public Schedule update(Long scheduleId, Schedule request) {
        Set<ConstraintViolation<Schedule>> violations = validator.validate(request);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        Schedule scheduleWithName = scheduleRepository.findByName(request.getName());

        if(scheduleWithName != null && scheduleWithName.getId().equals(scheduleId))
            throw new ResourceValidationException(ENTITY,
                    "The name pf the day already exists.");

        return scheduleRepository.findById(scheduleId).map(schedule ->
                scheduleRepository.save(
                        schedule.withName(request.getName())

                )).orElseThrow(()->new ResourceNotFoundException(ENTITY,scheduleId));
    }

    @Override
    public ResponseEntity<?> delete(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).map(schedule -> {
            scheduleRepository.delete(schedule);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY, scheduleId));
    }
}
