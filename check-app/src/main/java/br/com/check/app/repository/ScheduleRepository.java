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

    @Query(value = """
            select s.id, s.schedule_id, s.payment_payment_id , s.created_at, s.updated_at, s.schedule_date,e.exam_id, exam_uuid , e.exam_name,
            e.exam_type, e.exam_value, p.payment_id , p.payment_uuid, p.payment_type, p.value
            from schedule s, exam e, payment p
            where s.schedule_id = :uuid and p.payment_id  = s.id and e.schedule_fk  = s.id""", nativeQuery = true)
    Optional<Schedule> findScheduleByScheduleId(@Param("uuid") UUID uuid);


}
