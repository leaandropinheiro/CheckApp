package br.com.check.app.repository;

import br.com.check.app.entity.Schedule;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    Optional<Schedule> findScheduleById(@Param("uuid") UUID uuid);

}
