package br.com.check.app.service.imp;

import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.entity.Exam;
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
import java.util.UUID;

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

        Schedule schedule = ScheduleUtils.convertDtoToEntity(scheduleDto);

        increment(schedule);

        scheduleRepository.save(schedule);

        log.info("ScheduleService.create() -> finish process, schedule {}", this.objectMapper.writeValueAsString(schedule));

        return ScheduleUtils.convertEntityToDto(schedule);
    }

    @Override
    public List<ScheduleDto> findSchedulesByDate(Long id) {
//        return scheduleRepository.findSchedulesByOrderByScheduleDate(id);
        return null;
    }

    @Override
    public ScheduleDto findScheduleById(UUID id) {

        Schedule scheduleByScheduleId = scheduleRepository.findScheduleByScheduleId(id);

        return null;
    }

    private void increment(Schedule schedule) {

        log.info("ScheduleService.increment() -> init process");

        schedule.setExams(examService.createExam(schedule.getExams()));
        schedule.setPayment(paymentService.createPayment(schedule.getPayment(), schedule
                .getExams()
                .stream()
                .map(Exam::getExamValue)
                .reduce(0d, Double::sum)));
    }
}
