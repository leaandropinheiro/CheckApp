package br.com.check.app.repository;

import br.com.check.app.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    Optional<Exam> findExamById(UUID examUuid);

    void deleteExamById(UUID examUuid);
}
