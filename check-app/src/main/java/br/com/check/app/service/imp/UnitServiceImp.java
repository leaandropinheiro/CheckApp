package br.com.check.app.service.imp;

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
  public void createUnit(String name, String region) {

    this.unitRepository.save(Unit.builder()
            .unitName(name)
            .region(region)
            .build());
  }
}
