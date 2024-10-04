package br.com.check.app.entity;


import br.com.check.app.entity.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "payment")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;
    @Builder.Default
    private UUID paymentUuid = UUID.randomUUID();
    private PaymentType paymentType;
    private Double value;

}