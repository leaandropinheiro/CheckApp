package br.com.check.app.controller;

import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<ScheduleDto> getAllSchedulesByDate() {
//        return scheduleService.findSchedulesByDate();
        return null;
    }

    @GetMapping("/{uuid}")
    public ScheduleDto getScheduleById(@PathVariable UUID uuid) {
        return scheduleService.findScheduleById(uuid);
    }
}
