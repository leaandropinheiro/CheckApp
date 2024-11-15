package br.com.check.app.dto;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
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

  private List<ExamDto> exams;
  private PaymentDto payment;
  private OffsetDateTime scheduleDate;


}
