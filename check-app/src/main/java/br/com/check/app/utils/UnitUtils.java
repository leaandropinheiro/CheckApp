package br.com.check.app.utils;

import br.com.check.app.dto.UnitDto;
import br.com.check.app.entity.Unit;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitUtils {

  public UnitDto convertEntityToDto(final Unit unit) {

    return UnitDto.builder()
        .unitId(unit.getUnitId())
        .region(unit.getRegion())
        .unitName(unit.getUnitName())
        .services(unit.getServices())
        .specialty(unit.getSpecialty())
        .build();

  }

  public Unit convertDtoToEntity(final UnitDto unit) {

    return Unit.builder()
        .unitId(unit.getUnitId())
        .region(unit.getRegion())
        .unitName(unit.getUnitName())
        .services(unit.getServices())
        .specialty(unit.getSpecialty())
        .build();
  }
}
