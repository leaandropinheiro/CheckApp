package br.com.check.app.service;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.dto.ScheduleForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {

    UUID create(ScheduleForm scheduleDto) throws JsonProcessingException;

    ScheduleDto findScheduleById(UUID id);

    ScheduleDto updateDate(UUID uuid, OffsetDateTime updatedDateTime);

    List<ExamDto> getExamFromSchedule(UUID scheduleId);

    ScheduleDto deleteSchedule(UUID uuid);

  List<ScheduleDto> findAllSchedules();

//    ScheduleDto updatePaymentStatus(UUID uuid, PaymentStatus paymentStatus);
}
