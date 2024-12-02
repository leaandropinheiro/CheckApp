package br.com.check.app.controller;

import br.com.check.app.dto.UnitDto;
import br.com.check.app.entity.Unit;
import br.com.check.app.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit")
@RequiredArgsConstructor
public class UnitController {

  private final UnitService unitService;

  @PostMapping
  public void unitCreation(@RequestParam String name, @RequestParam String region, @RequestParam String specialty, @RequestParam String services) {

    this.unitService.createUnit(name, region, specialty, services);

  }

  @GetMapping("/{unitId}")
  public Unit findUnitById(@PathVariable Long unitId) {

    return this.unitService.findUnit(unitId);
  }
}
