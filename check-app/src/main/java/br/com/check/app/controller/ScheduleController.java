package br.com.check.app.controller;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.entity.Exam;
import br.com.check.app.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/check-app")
@AllArgsConstructor
public class ScheduleController {

    private ScheduleService scheduleService;

    @PostMapping()
    @Transactional
    public ScheduleDto saveSchedule(@RequestBody ScheduleDto scheduleDto) throws JsonProcessingException {
        return scheduleService.create(scheduleDto);
    }

    @GetMapping("/{uuid}")
    public ScheduleDto getSchedule(@PathVariable UUID uuid) {
        return scheduleService.findScheduleById(uuid);
    }

    //a data será enviada pelo front-end para ser salvo dentro do banco de dados
    @PutMapping("/{uuid}")
    @Transactional
    public ScheduleDto updateDate(@PathVariable UUID uuid,
                                  @RequestParam OffsetDateTime newScheduleDate) {

        return scheduleService.updateDate(uuid, newScheduleDate);

    }

    @GetMapping("/{uuid}/exams")
    public List<ExamDto> getAllExams(@PathVariable("uuid") UUID uuid) {
        return scheduleService.getExamFromSchedule(uuid);
    }
}
