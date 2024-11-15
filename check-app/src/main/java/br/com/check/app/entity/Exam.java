package br.com.check.app.entity;

import br.com.check.app.entity.enums.ExamType;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
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
    private String examName;
    private Double examValue;
    private ExamType examType;

}