package br.com.check.app.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@ToString
public class Schedule extends AbstractEntity<Schedule> {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    @OneToMany(targetEntity = Exam.class, cascade = {CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn
    @NotNull
    private List<Exam> exams;
    @OneToOne(targetEntity = Unit.class, cascade = {CascadeType.REFRESH, CascadeType.MERGE})
    private Unit unit;
    @OneToOne( targetEntity = Payment.class, cascade = {CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true)
    @NotNull
    private Payment payment;
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm")
    private OffsetDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm")
    private OffsetDateTime updatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm")
    @Future
    private OffsetDateTime scheduleDate;

}