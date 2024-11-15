package br.com.check.app.repository;

import br.com.check.app.entity.Unit;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends JpaRepository<Unit, UUID> {
}
