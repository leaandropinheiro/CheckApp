package br.com.check.app.repository;

import br.com.check.app.entity.Unit;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, UUID> {
  @Transactional
  @Modifying
  @Query(nativeQuery = true, value = """
      INSERT INTO unit (id, unit_name, region, specialty, services, unit_id)
      VALUES (:id, :unitName , :region, :specialty, :services, nextval('unit_seq'));
      """)
  void saveUnit(@Param(value = "id")final UUID id,
                @Param(value = "unitName") final String unitName,
                @Param(value = "region") final String region,
                @Param(value = "specialty") final String specialty,
                @Param(value = "services") final String services);


  Optional<Unit> findUnitByUnitId(Long id);
}
