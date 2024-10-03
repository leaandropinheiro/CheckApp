package br.com.check.app.entity;

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
    @OneToMany(targetEntity = Exam.class)
    private List<Exam> exams;
    @OneToOne
    private Payment payment;
    private OffsetDateTime scheduleDate;

}