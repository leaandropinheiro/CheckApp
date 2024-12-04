package br.com.check.app.utils;

import static java.util.Objects.isNull;

import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.dto.ScheduleForm;
import br.com.check.app.entity.Schedule;
import br.com.check.app.entity.Unit;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;


@UtilityClass
public class ScheduleUtils {

    public Schedule convertDtoToEntity(ScheduleDto scheduleDto) {
        return Schedule
                .builder()
                .id(isNull(scheduleDto.getScheduleId()) ? UUID.randomUUID() : scheduleDto.getScheduleId())
                .exams(CollectionUtils.isEmpty(scheduleDto.getExams()) ? null : ExamUtils.convertListDtoToEntity(scheduleDto.getExams()))
                .payment(isNull(scheduleDto.getPayment()) ? null : PaymentUtils.convertDtoToEntity(scheduleDto.getPayment()))
                .createdAt(isNull(scheduleDto.getCreatedAt()) ? OffsetDateTime.now() : scheduleDto.getCreatedAt())
                .updatedAt(isNull(scheduleDto.getUpdatedAt()) ? OffsetDateTime.now() : scheduleDto.getUpdatedAt())
                .scheduleDate(scheduleDto.getScheduleDate())
                .build();
    }

    public Schedule convertFormToEntity(ScheduleForm scheduleDto) {

        return Schedule
                .builder()
                .id(UUID.randomUUID())
                .exams(CollectionUtils.isEmpty(scheduleDto.getExams()) ? null : ExamUtils.convertListDtoToEntity(scheduleDto.getExams()))
                .payment(isNull(scheduleDto.getPayment()) ? null : PaymentUtils.convertDtoToEntity(scheduleDto.getPayment()))
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .scheduleDate(scheduleDto.getScheduleDate())
                .unitId(scheduleDto.getUnitId())
                .build();
    }

    public ScheduleDto convertEntityToDto(Schedule scheduleSaved) {
        return ScheduleDto.builder()
                .scheduleId(scheduleSaved.getId())
                .exams(ExamUtils.convertoListToDtoList(scheduleSaved.getExams()))
                .payment(PaymentUtils.convertEntityToDto(scheduleSaved.getPayment()))
                .createdAt(scheduleSaved.getCreatedAt())
                .updatedAt(scheduleSaved.getUpdatedAt())
                .scheduleDate(scheduleSaved.getScheduleDate())
                .unitId(scheduleSaved.getUnitId())
                .build();
    }
}
