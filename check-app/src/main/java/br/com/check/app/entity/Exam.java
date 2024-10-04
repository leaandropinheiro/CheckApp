package br.com.check.app.entity;

import br.com.check.app.entity.enums.ExamType;
import jakarta.persistence.*;
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
    @Column(name = "exam_id")
    private Long id;
    @Builder.Default
    private UUID examUuid = UUID.randomUUID();
    private String examName;
    private Double examValue;
    private ExamType examType;

}