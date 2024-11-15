package br.com.check.app.controller;

import br.com.check.app.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/unit")
@RequiredArgsConstructor
public class UnitController {

  private final UnitService unitService;

  @PostMapping
  public void unitCreation(@RequestParam String name, @RequestParam String region) {

    this.unitService.createUnit(name, region);

  }


}
