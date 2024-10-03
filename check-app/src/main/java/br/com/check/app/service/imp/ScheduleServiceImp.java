package br.com.check.app.service.imp;

import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.entity.Schedule;
import br.com.check.app.repository.ScheduleRepository;
import br.com.check.app.service.ExamService;
import br.com.check.app.service.PaymentService;
import br.com.check.app.service.ScheduleService;
import br.com.check.app.utils.ScheduleUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleServiceImp implements ScheduleService {

    private ScheduleRepository scheduleRepository;
    private ExamService examService;
    private PaymentService paymentService;

    @Override
    public ScheduleDto scheduleCreation(ScheduleDto scheduleDto) {

        Schedule scheduleSaved = scheduleRepository.save(ScheduleUtils.convertDtoToEntity(scheduleDto));
        return ScheduleUtils.convertEntityToDto(scheduleSaved);
    }
}
