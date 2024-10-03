package br.com.check.app.service;

import br.com.check.app.dto.ScheduleDto;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {

    ScheduleDto scheduleCreation(ScheduleDto scheduleDto);
}
