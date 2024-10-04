package br.com.check.app.service.imp;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.entity.Exam;
import br.com.check.app.repository.ExamRepository;
import br.com.check.app.service.ExamService;
import br.com.check.app.utils.ExamUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ExamServiceImp implements ExamService {

    private ExamRepository examRepository;

    @Override
    public List<Exam> createExam(List<Exam> exams) {

        if (exams.isEmpty()) {
            throw new RuntimeException("Erro ao criar exame");
        }

        exams.forEach(exam -> {
            switch (exam.getExamType()) {
                case COLETA -> exam.setExamValue(100d);
                case PRESENCIAL -> exam.setExamValue(50d);
                default -> throw new RuntimeException("Erro ao criar exame");
            }
        });

        examRepository.saveAll(exams);

        return exams;
    }
}
