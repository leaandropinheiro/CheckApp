package br.com.check.app.dto;

import br.com.check.app.entity.enums.ExamType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link br.com.check.app.entity.Exam}
 */
@AllArgsConstructor
@Getter
public class ExamDto implements Serializable {
    private UUID examId;
    private String examName;
    private Double examValue;
    private ExamType examType;
}