package br.com.check.app.service;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.ScheduleDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
public interface ScheduleService {

    ScheduleDto create(ScheduleDto scheduleDto) throws JsonProcessingException;

    ScheduleDto findScheduleById(UUID id);

    ScheduleDto updateDate(UUID uuid, OffsetDateTime updatedDateTime);

    List<ExamDto> getExamFromSchedule(UUID scheduleId);

    ScheduleDto deleteSchedule(UUID uuid);
}
