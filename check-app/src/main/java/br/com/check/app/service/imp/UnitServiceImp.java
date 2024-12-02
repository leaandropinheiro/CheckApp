package br.com.check.app.service.imp;

import br.com.check.app.dto.UnitDto;
import br.com.check.app.entity.Unit;
import br.com.check.app.repository.UnitRepository;
import br.com.check.app.service.UnitService;
import org.springframework.stereotype.Service;

@Service
public class UnitServiceImp implements UnitService {


  private final UnitRepository unitRepository;

  public UnitServiceImp(final UnitRepository unitRepository) {
    this.unitRepository = unitRepository;
  }

  @Override
  public void createUnit(String name, String region, String specialty, String services) {

    final Unit unit = Unit.builder()
        .unitName(name)
        .region(region)
        .specialty(specialty)
        .services(services)
        .build();

    this.unitRepository.saveUnit(unit.getId(),unit.getUnitName(), unit.getRegion(), unit.getSpecialty(), unit.getSpecialty());
  }

  @Override
  public Unit findUnitByUnitId(final Long unitId) {

    return this.unitRepository.findUnitByUnitId(unitId)
        .orElseThrow(() -> new RuntimeException("Unit Not Found"));
  }

}
