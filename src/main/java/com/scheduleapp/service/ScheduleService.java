package com.scheduleapp.service;

import com.scheduleapp.dto.CreateScheduleRequest;
import com.scheduleapp.dto.CreateScheduleResponse;
import com.scheduleapp.entity.Schedule;
import com.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CreateScheduleResponse createSchedule(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContents(),
                request.getWriterName(),
                request.getPassword()
        );
        Schedule createdSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponse(
                createdSchedule.getId(),
                createdSchedule.getTitle(),
                createdSchedule.getContents(),
                createdSchedule.getWriterName(),
                createdSchedule.getCreatedDate(),
                createdSchedule.getModifiedDate()
        );
    }
}
