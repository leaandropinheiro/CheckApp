package br.com.check.app.dto;

import lombok.*;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link br.com.check.app.entity.Schedule}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class ScheduleDto implements Dto<ScheduleDto> {
    private UUID scheduleId;
    private List<ExamDto> exams;
    private PaymentDto payment;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private OffsetDateTime scheduleDate;
    private UnitDto unit;

}