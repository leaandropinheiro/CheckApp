package br.com.check.app.controller;

import br.com.check.app.controller.documentation.UnitDocs;
import br.com.check.app.dto.UnitDto;
import br.com.check.app.dto.UnitExamDto;
import br.com.check.app.entity.Unit;
import br.com.check.app.service.UnitExamService;
import br.com.check.app.service.UnitService;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unit")
@RequiredArgsConstructor
public class UnitController implements UnitDocs {

  private final UnitService unitService;
  private final UnitExamService unitExamService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void unitCreation(@RequestParam String name,
                           @RequestParam String region,
                           @RequestParam String specialty,
                           @RequestParam String services) {

    this.unitService.createUnit(name, region, specialty, services);
  }

  @GetMapping("/{unitId}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public Unit findUnitById(@PathVariable Long unitId) {

    return this.unitService.findUnitByUnitId(unitId);
  }

  @GetMapping("/{unitId}/unitExams")
  @ResponseStatus(HttpStatus.OK)
  public List<UnitExamDto> findUnitExamsByUnitId(@PathVariable Long unitId) {

    return unitExamService.findAllExamsByUnitId(unitId);
  }

  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<UnitDto> findAllUnits() {
    return this.unitService.findAll();
  }

  @PatchMapping("/{unitId}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public void addExamIntoUnit(@PathVariable Long unitId,
                              @RequestBody List<UnitExamDto> unitExamDto) {

    this.unitExamService.unitExamCreation(unitId, unitExamDto);
  }
}
