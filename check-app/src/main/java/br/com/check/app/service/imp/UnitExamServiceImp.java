package br.com.check.app.service.imp;

import br.com.check.app.dto.UnitExamDto;
import br.com.check.app.repository.UnitExamRepository;
import br.com.check.app.service.UnitExamService;
import br.com.check.app.utils.UnitExamUtils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UnitExamServiceImp implements UnitExamService {

  private final UnitExamRepository unitExamRepository;

  public void unitExamCreation(final Long unitId, List<UnitExamDto> unitExamDto) {

    unitExamDto.stream().map(UnitExamUtils::convertDtoToEntity)
        .forEach(unitExam -> unitExamRepository.saveUnitExam(unitExam.getId(), unitId, unitExam.getExamName(), unitExam.getExamValue()));
  }

  @Override
  public List<UnitExamDto> findAllExamsByUnitId(final Long unitId) {

    return unitExamRepository.findByUnitId(unitId).stream().map(UnitExamUtils::convertEntityToDto).toList();
  }
}
