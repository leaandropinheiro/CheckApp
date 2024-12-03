package br.com.check.app.service;

import br.com.check.app.dto.UnitDto;
import br.com.check.app.entity.Unit;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UnitService {


  void createUnit(String name, String region, String specialty, String services);

  Unit findUnitByUnitId(Long unitId);

  List<UnitDto> findAll();

}
