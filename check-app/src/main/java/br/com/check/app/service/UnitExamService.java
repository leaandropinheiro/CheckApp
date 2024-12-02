package br.com.check.app.service;

import br.com.check.app.dto.UnitExamDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UnitExamService {

  void unitExamCreation(final Long unitId, List<UnitExamDto> unitExamDto);

  List<UnitExamDto> findAllExamsByUnitId(Long unitId);
}
