package br.com.check.app.service.imp;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.dto.ScheduleForm;
import br.com.check.app.entity.Exam;
import br.com.check.app.entity.Schedule;
import br.com.check.app.repository.ScheduleRepository;
import br.com.check.app.service.ExamService;
import br.com.check.app.service.PaymentService;
import br.com.check.app.service.ScheduleService;
import br.com.check.app.utils.ExamUtils;
import br.com.check.app.utils.ScheduleUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ScheduleServiceImp implements ScheduleService {

    private final String SCHEDULE_NOT_FOUND = "Schedule not found";

    private ScheduleRepository scheduleRepository;
    private ObjectMapper objectMapper;
    private ExamService examService;
    private PaymentService paymentService;

    @Override
    public UUID create(ScheduleForm scheduleForm) {

        Schedule schedule = ScheduleUtils.convertDtoToEntity(scheduleForm);

        increment(schedule);

        scheduleRepository.save(schedule);

        return schedule.getId();
    }

    @Override
    public ScheduleDto findScheduleById(UUID id) {

        return ScheduleUtils.convertEntityToDto(scheduleRepository.findScheduleByScheduleId(id)
                .orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND)));
    }

    @Override
    public ScheduleDto updateDate(UUID uuid, OffsetDateTime updatedDateTime) {


        Schedule schedule = scheduleRepository.findScheduleByScheduleId(uuid)
                .orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND));
        schedule.setScheduleDate(updatedDateTime);

        scheduleRepository.save(schedule);

        return ScheduleUtils.convertEntityToDto(schedule);
    }

    @Override
    public List<ExamDto> getExamFromSchedule(UUID scheduleId) {

        Schedule schedule = scheduleRepository.findScheduleByScheduleId(scheduleId).orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND));

        return ExamUtils.convertoListToDtoList(schedule.getExams());
    }
    @Override
    public ScheduleDto deleteSchedule(UUID uuid) {

        Schedule schedule = scheduleRepository.findScheduleByScheduleId(uuid).orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND));

        ScheduleDto scheduleDto = ScheduleUtils.convertEntityToDto(schedule);

        scheduleRepository.delete(schedule);

        return scheduleDto;
    }

    private void increment(Schedule schedule) {

        schedule.setUpdatedAt(OffsetDateTime.now());

        schedule.setExams(examService.createExam(schedule.getExams()));
        schedule.setPayment(paymentService.createPayment(schedule.getPayment(), schedule
                .getExams()
                .stream()
                .map(Exam::getExamValue)
                .reduce(0d, Double::sum)));
    }
}
