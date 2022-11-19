package com.DermApp.Backend.diagnostic.domain.persistence;

import com.DermApp.Backend.diagnostic.domain.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    Schedule findScheduleById(Long scheduleId);
    Schedule findByName(String name);
}
