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
public class Unit extends AbstractEntity<Unit>{

  @Id
  @Builder.Default
  private UUID id = UUID.randomUUID();
  private String unitName;
  private String region;
  private String specialty;
  private String services;
  @Column(name = "unit_id", updatable = false)
  @SequenceGenerator(name = "unit_id",sequenceName = "unit_seq", allocationSize = 1)
  private Long unitId;
}
