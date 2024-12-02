package br.com.check.app.entity;

import br.com.check.app.entity.enums.ExamType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Exam extends AbstractEntity<Exam> {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    private Long examCode;
    private String examName;
    private Double examValue;
    private ExamType examType;

}