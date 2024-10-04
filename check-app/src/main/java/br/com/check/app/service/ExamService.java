package br.com.check.app.service;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.entity.Exam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {

    List<Exam> createExam(List<Exam> exams);
}
