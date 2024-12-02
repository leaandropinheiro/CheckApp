package br.com.check.app.dto;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * formDTO for {@link br.com.check.app.entity.Schedule}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleForm implements Dto<ScheduleForm> {


  private UUID scheduleId ;
  private List<ExamDto> exams;
  private PaymentDto payment;
  private OffsetDateTime scheduleDate;
  private Long unitId ;

}
