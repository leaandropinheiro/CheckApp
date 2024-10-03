package br.com.check.app.controller;

import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.service.ScheduleService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/check-app")
@AllArgsConstructor
public class ScheduleController {

    private ScheduleService scheduleService;

    @PostMapping()
    @Transactional
    public ScheduleDto saveSchedule(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.scheduleCreation(scheduleDto);
    }
}
