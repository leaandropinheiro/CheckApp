package br.com.check.app.repository;

import br.com.check.app.dto.ExamDto;
import br.com.check.app.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    @Query(value = """
        select e from exam e where e.exam_id = :examId 
        """, nativeQuery = true)
    Optional<Exam> findExamById(@Param("examId") UUID examId);


}
