package br.com.check.app.utils;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.entity.Exam;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.isNull;

@UtilityClass
public class ExamUtils {
    public List<Exam> convertListDtoToEntity(List<ExamDto> exams) {
        return exams.stream().map(ExamUtils::convertDtoToEntity).toList();
    }

    public Exam convertDtoToEntity(ExamDto examDto) {
        return Exam.builder()
                .id(isNull(examDto.getExamId()) ? UUID.randomUUID() : examDto.getExamId())
                .examName(examDto.getExamName())
                .examType(examDto.getExamType())
                .examValue(examDto.getExamValue())
                .build();
    }


    public static List<ExamDto> convertoListToDtoList(List<Exam> exams) {
        return exams.stream().map(ExamUtils::convertEntityToDto).toList();
    }

    public ExamDto convertEntityToDto(Exam exam) {
        return ExamDto.builder()
                .examId(exam.getId())
                .examName(exam.getExamName())
                .examType(exam.getExamType())
                .examValue(exam.getExamValue())
                .build();
    }
}
