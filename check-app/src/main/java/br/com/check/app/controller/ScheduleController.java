package br.com.check.app.controller;

import br.com.check.app.controller.documentation.ScheduleDocs;
import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.dto.ScheduleForm;
import br.com.check.app.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController implements ScheduleDocs {

    private final ScheduleService scheduleService;

    @Override
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public UUID createSchedule(@RequestBody ScheduleForm scheduleForm) throws JsonProcessingException {

        return scheduleService.create(scheduleForm);
    }

    @Override
    @GetMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDto getSchedule(@PathVariable UUID uuid) {

        return scheduleService.findScheduleById(uuid);
    }

    //a data será enviada pelo front-end para ser salvo dentro do banco de dados
    @Override
    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public ScheduleDto updateDate(@PathVariable UUID uuid,
                                  @RequestParam OffsetDateTime newScheduleDate) {

        return scheduleService.updateDate(uuid, newScheduleDate);

    }

    @Override
    @GetMapping("/{uuid}/exams")
    @ResponseStatus(HttpStatus.OK)
    public List<ExamDto> getAllExams(@PathVariable("uuid") UUID uuid) {
        return scheduleService.getExamFromSchedule(uuid);
    }

    @Override
    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public ScheduleDto deleteSchedule(@PathVariable("uuid") UUID uuid) {

        return scheduleService.deleteSchedule(uuid);
    }

//    @PatchMapping("/{uuid}")
//    @ResponseStatus(HttpStatus.OK)
//    public ScheduleDto updatePaymentStatus(@PathVariable UUID uuid, PaymentStatus paymentStatus) {
//
//        return this.scheduleService.updatePaymentStatus(uuid, paymentStatus);
//    }
}
