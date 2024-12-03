package br.com.check.app.dto;

import br.com.check.app.entity.enums.ExamType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * DTO for {@link br.com.check.app.entity.Exam}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ExamDto implements Dto<ExamDto> {
    private UUID examId;
    private Long examCode;
    private String examName;
    private Double examValue;
    private ExamType examType;
}