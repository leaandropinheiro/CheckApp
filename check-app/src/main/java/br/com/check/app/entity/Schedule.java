package br.com.check.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Schedule implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Builder.Default
    private UUID scheduleId = UUID.randomUUID();
    @OneToMany(targetEntity = Exam.class)
    @JoinColumn(name = "schedule_fk")
    private List<Exam> exams;
    @OneToOne( targetEntity = Payment.class)
    private Payment payment;
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm")
    private OffsetDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm")
    private OffsetDateTime updatedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH:mm")
    @Future
    private OffsetDateTime scheduleDate;

}