package br.com.check.app.repository;

import br.com.check.app.entity.Exam;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Optional<Exam> findExamById(UUID examUuid);

    void deleteExamById(UUID examUuid);
}
