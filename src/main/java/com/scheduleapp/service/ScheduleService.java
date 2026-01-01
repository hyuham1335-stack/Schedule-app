package com.scheduleapp.service;

import com.scheduleapp.dto.scheduledto.*;
import com.scheduleapp.entity.Schedule;
import com.scheduleapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 일정 생성
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

    // 선택 일정 조회
    @Transactional(readOnly = true)
    public FindOneScheduleResponse findOneSchedule(Long scheduleId) {
        Schedule findSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("Schedule not found with id " + scheduleId)
        );

        return new FindOneScheduleResponse(
                findSchedule.getId(),
                findSchedule.getTitle(),
                findSchedule.getContents(),
                findSchedule.getWriterName(),
                findSchedule.getCreatedDate(),
                findSchedule.getModifiedDate()
        );
    }

    // 전체 일정 조회
    @Transactional(readOnly = true)
    public List<FindOneScheduleResponse> findAllSchedule(String writerName) {

        List<Schedule> findSchedules = null;

        if(writerName == null){
            findSchedules = scheduleRepository.findAll();
        } else {
            findSchedules = scheduleRepository.findByWriterName(writerName);
        }

        findSchedules.sort(Comparator.comparing(Schedule::getModifiedDate).reversed());

        return findSchedules.stream()
                .map(schedule -> new FindOneScheduleResponse(
                                schedule.getId(),
                                schedule.getTitle(),
                                schedule.getContents(),
                                schedule.getWriterName(),
                                schedule.getCreatedDate(),
                                schedule.getModifiedDate()
                )).toList();
    }

    // 선택한 일정 수정
    @Transactional
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {
        Schedule findSchedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("Schedule not found with id " + scheduleId)
        );

        if(!request.getPassword().equals(findSchedule.getPassword())){
            throw new IllegalStateException("비밀번호가 일치하지 않습니다.");
        }

        findSchedule.updateSchedule(request.getTitle(), request.getWriterName());

        return new UpdateScheduleResponse(
                findSchedule.getId(),
                findSchedule.getTitle(),
                findSchedule.getContents(),
                findSchedule.getWriterName()
        );
    }

    // 선택한 일정 삭제
    @Transactional
    public void delete(Long scheduleId, DeleteScheduleRequest request) {
        boolean existence = scheduleRepository.existsById(scheduleId);

        if(!existence){
            throw new IllegalStateException("Schedule not found with id " + scheduleId);
        }

        scheduleRepository.deleteById(scheduleId);
    }
}
