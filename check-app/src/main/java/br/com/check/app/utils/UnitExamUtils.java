package br.com.check.app.utils;

import br.com.check.app.dto.UnitExamDto;
import br.com.check.app.entity.UnitExam;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UnitExamUtils {

  public UnitExamDto convertEntityToDto(final UnitExam unit) {

    return UnitExamDto.builder()
        .unitId(unit.getUnitId())
        .examCode(unit.getExamCode())
        .examName(unit.getExamName())
        .examValue(unit.getExamValue())
        .build();

  }

  public UnitExam convertDtoToEntity(final UnitExamDto unit) {

    return UnitExam.builder()
        .examName(unit.getExamName())
        .examCode(unit.getExamCode())
        .unitId(unit.getUnitId())
        .build();
  }
}
