package br.com.check.app.entity;

import br.com.check.app.repository.UnitRepository;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Positive;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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
