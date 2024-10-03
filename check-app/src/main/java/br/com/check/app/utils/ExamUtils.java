package br.com.check.app.utils;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.entity.Exam;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ExamUtils {
    public List<Exam> convertListDtoToEntity(List<ExamDto> exams) {
        return exams.stream().map(ExamUtils::convertDtoToEntity).toList();
    }

    public Exam convertDtoToEntity(ExamDto examDto) {
        return Exam.builder()
                .examName(examDto.getExamName())
                .examType(examDto.getExamType())
                .examValue(examDto.getExamValue())
                .build();
    }


}
