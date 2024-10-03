package br.com.check.app.service;

import br.com.check.app.dto.ScheduleDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {

    ScheduleDto create(ScheduleDto scheduleDto) throws JsonProcessingException;
}
