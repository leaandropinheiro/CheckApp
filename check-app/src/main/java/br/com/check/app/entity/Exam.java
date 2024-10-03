package br.com.check.app.entity;

import br.com.check.app.entity.enums.ExamType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Builder
@Entity(name = "exam")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Builder.Default
    private UUID examId = UUID.randomUUID();
    private String examName;
    private Double examValue;
    private ExamType examType;

}