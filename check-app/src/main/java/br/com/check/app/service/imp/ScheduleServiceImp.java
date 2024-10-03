package br.com.check.app.service.imp;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.PaymentDto;
import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.entity.Schedule;
import br.com.check.app.repository.ScheduleRepository;
import br.com.check.app.service.ExamService;
import br.com.check.app.service.PaymentService;
import br.com.check.app.service.ScheduleService;
import br.com.check.app.utils.ScheduleUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ScheduleServiceImp implements ScheduleService {

    private ScheduleRepository scheduleRepository;
    private ObjectMapper objectMapper;
    private ExamService examService;
    private PaymentService paymentService;

    @Override
    public ScheduleDto create(ScheduleDto scheduleDto) throws JsonProcessingException {

        log.info("ScheduleService.create() -> init process, schedule {}", this.objectMapper.writeValueAsString(scheduleDto));

        ScheduleDto incrementedSchedule = increment(scheduleDto);

        Schedule scheduleSaved = scheduleRepository.save(ScheduleUtils.convertDtoToEntity(scheduleDto));
        return ScheduleUtils.convertEntityToDto(scheduleSaved);
    }

    private ScheduleDto increment(ScheduleDto scheduleDto) {

        log.info("ScheduleService.increment() -> init process");

        examService.createExam(scheduleDto.getExams());
        paymentService.createPayment(scheduleDto.getPayment());

        return
    }
}
