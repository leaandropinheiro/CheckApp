package br.com.check.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Builder.Default
    private UUID scheduleId = UUID.randomUUID();
    @OneToMany(targetEntity = Exam.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_fk")
    private List<Exam> exams;
    @OneToOne( targetEntity = Payment.class, cascade = CascadeType.ALL )
    private Payment payment;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private OffsetDateTime scheduleDate;

}