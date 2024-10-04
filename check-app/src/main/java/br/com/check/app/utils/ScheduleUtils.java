package br.com.check.app.utils;

import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.entity.Schedule;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.time.OffsetDateTime;
import java.util.UUID;

import static java.util.Objects.isNull;


@UtilityClass
public class ScheduleUtils {

    public Schedule convertDtoToEntity(ScheduleDto scheduleDto) {
        return Schedule
                .builder()
                .scheduleId(isNull(scheduleDto.getScheduleId()) ? UUID.randomUUID() : scheduleDto.getScheduleId())
                .exams(CollectionUtils.isEmpty(scheduleDto.getExams()) ? null : ExamUtils.convertListDtoToEntity(scheduleDto.getExams()))
                .payment(isNull(scheduleDto.getPayment()) ? null : PaymentUtils.convertDtoToEntity(scheduleDto.getPayment()))
                .scheduleDate(OffsetDateTime.now())
                .build();
    }

    public ScheduleDto convertEntityToDto(Schedule scheduleSaved) {
        return ScheduleDto.builder()
                .scheduleId(scheduleSaved.getScheduleId())
                .exams(ExamUtils.convertoListToDtoList(scheduleSaved.getExams()))
                .payment(PaymentUtils.convertEntityToDto(scheduleSaved.getPayment()))
                .scheduleDate(scheduleSaved.getScheduleDate())
                .build();
    }
}
