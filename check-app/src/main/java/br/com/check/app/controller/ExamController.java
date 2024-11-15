package br.com.check.app.controller;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.service.ExamService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamService examService;

    @GetMapping("/{uuid}")
    public ExamDto findExamById(@PathVariable("uuid") UUID uuid) {
        return examService.findExamById(uuid);
    }

    @DeleteMapping("/{uuid}")
    @Transactional
    public void deleteExamById(@PathVariable("uuid") UUID uuid) {
      examService.deleteExam(uuid);
    }
}
