package br.com.check.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class UnitExam extends AbstractEntity<UnitExam>{

  @Id
  @Builder.Default
  private UUID id = UUID.randomUUID();
  private String examName;
  @Column(name = "exam_code", updatable = false)
  @SequenceGenerator(name = "exam_code",sequenceName = "exam_code_seq", allocationSize = 1)
  private Long examCode;
  private Long unitId;
}
