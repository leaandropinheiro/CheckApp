package br.com.check.app.repository;

import br.com.check.app.entity.UnitExam;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitExamRepository extends JpaRepository<UnitExam, UUID> {

  @Modifying
  @Transactional
  @Query(nativeQuery = true, value = """
        INSERT INTO unit_exam (id,unit_id,exam_name,exam_code, exam_value)
        VALUES (:id, :unitId, :examName, nextval('exam_code_seq'), :examValue)
      """)
  void saveUnitExam(@Param("id") final UUID id,
                    @Param("unitId") final Long unitId,
                    @Param("examName") final String examName,
                    @Param("examValue") final Long examValue);

  List<UnitExam> findByUnitId(Long unitId);

}
