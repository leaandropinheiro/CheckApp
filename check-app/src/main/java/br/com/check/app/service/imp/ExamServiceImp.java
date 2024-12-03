package br.com.check.app.service.imp;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.entity.Exam;
import br.com.check.app.exceptions.ExamException;
import br.com.check.app.repository.ExamRepository;
import br.com.check.app.service.ExamService;
import br.com.check.app.utils.ExamUtils;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExamServiceImp implements ExamService {

    private ExamRepository examRepository;

    @Override
    public List<Exam> createExam(List<Exam> exams) {

        if (exams.isEmpty()) {
            throw new ExamException("Erro ao criar exame");
        }

        exams.forEach(exam -> {
            switch (exam.getExamType()) {
                case COLETA -> exam.setExamValue(100d);
                case PRESENCIAL -> exam.setExamValue(50d);
            }
        });

        examRepository.saveAll(exams);

        return exams;
    }

    @Override
    public ExamDto findExamById(UUID examId) {
        return ExamUtils.convertEntityToDto(examRepository.findExamById(examId)
                .orElseThrow(() -> new RuntimeException("Exame não encontrado")));
    }

    @Override
    public void deleteExam(final UUID uuid) {
      examRepository.deleteExamById(uuid);
    }
}
