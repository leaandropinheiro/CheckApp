package br.com.check.app.service;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.entity.Exam;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public interface ExamService {

    List<Exam> createExam(List<Exam> exams);

    ExamDto findExamById(UUID examId);

    void deleteExam(UUID uuid);
}
