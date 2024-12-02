package br.com.check.app.repository;

import br.com.check.app.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    Optional<Schedule> findScheduleById(@Param("uuid") UUID uuid);

}
