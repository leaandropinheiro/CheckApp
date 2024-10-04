package br.com.check.app.repository;

import br.com.check.app.dto.ScheduleDto;
import br.com.check.app.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query(value = """
    select s from schedule s, exam e where s.schedule_id = scheduleId
    """, nativeQuery = true)
    List<ScheduleDto> findAllSchedulesByUser(UUID scheduleId);

    @Query(value = """
            select s.id, s.schedule_id, s.schedule_date, e.exam_id, exam_uuid , e.exam_name,
            e.exam_type, e.exam_value, p.payment_id , p.payment_uuid, p.payment_type, p.value
            from schedule s, exam e, payment p
            where s.schedule_id = :uuid and p.payment_id  = s.id and e.schedule_fk  = s.id
                   """, nativeQuery = true)
    Schedule findScheduleByScheduleId(@Param("uuid") UUID uuid);
}
