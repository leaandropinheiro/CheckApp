package br.com.check.app.service;

import br.com.check.app.dto.ExamDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExamService {

    void createExam(List<ExamDto> examDto);
}
