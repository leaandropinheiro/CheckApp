package br.com.check.app.service.imp;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.dto.ScheduleForm;
import br.com.check.app.entity.Schedule;
import br.com.check.app.entity.Unit;
import br.com.check.app.repository.ScheduleRepository;
import br.com.check.app.service.ExamService;
import br.com.check.app.service.PaymentService;
import br.com.check.app.service.ScheduleService;
import br.com.check.app.service.UnitService;
import br.com.check.app.utils.ExamUtils;
import br.com.check.app.utils.ScheduleUtils;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ScheduleServiceImp implements ScheduleService {

    private final String SCHEDULE_NOT_FOUND = "Schedule not found";

    private ScheduleRepository scheduleRepository;
    private ExamService examService;
    private PaymentService paymentService;
    private UnitService unitService;

    @Override
    public UUID create(ScheduleForm scheduleForm) {

        final Schedule schedule = increment(scheduleForm);

        scheduleRepository.save(schedule);

        return schedule.getId();
    }

    @Override
    public ScheduleDto findScheduleById(UUID id) {

        return ScheduleUtils.convertEntityToDto(scheduleRepository.findScheduleById(id)
                .orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND)));
    }

    @Override
    public ScheduleDto updateDate(UUID uuid, OffsetDateTime updatedDateTime) {


        Schedule schedule = scheduleRepository.findScheduleById(uuid)
                .orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND));
        schedule.setScheduleDate(updatedDateTime);
        schedule.setUpdatedAt(OffsetDateTime.now());

        scheduleRepository.save(schedule);

        return ScheduleUtils.convertEntityToDto(schedule);
    }

    @Override
    public List<ExamDto> getExamFromSchedule(UUID scheduleId) {

        Schedule schedule = scheduleRepository.findScheduleById(scheduleId).orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND));

        return ExamUtils.convertoListToDtoList(schedule.getExams());
    }
    @Override
    public ScheduleDto deleteSchedule(UUID uuid) {

        Schedule schedule = scheduleRepository.findScheduleById(uuid).orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND));

        ScheduleDto scheduleDto = ScheduleUtils.convertEntityToDto(schedule);

        scheduleRepository.delete(schedule);

        return scheduleDto;
    }

//    @Override
//    public ScheduleDto updatePaymentStatus(final UUID uuid, PaymentStatus paymentStatus) {
//
//        final ScheduleDto schedule = ScheduleUtils.convertEntityToDto(this.scheduleRepository.findScheduleById(uuid)
//            .orElseThrow(() -> new RuntimeException(SCHEDULE_NOT_FOUND)));
//
//        this.paymentService.updatePaymentStatus(schedule.getPayment(), paymentStatus);
//
//        return schedule;
//    }

    @SneakyThrows
    private Schedule increment(ScheduleForm scheduleForm) {

        final Unit unitByUnitId = this.unitService.findUnitByUnitId(scheduleForm.getUnitId());

        final Schedule schedule = ScheduleUtils.convertFormToEntity(scheduleForm, unitByUnitId);

        schedule.setUpdatedAt(OffsetDateTime.now());
        schedule.setExams(examService.createExam(schedule.getExams()));
        schedule.setPayment(paymentService.createPayment(schedule.getPayment()));

        return schedule;
    }
}
