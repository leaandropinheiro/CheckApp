package br.com.check.app.entity;


import br.com.check.app.entity.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity(name = "payment")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;
    @Builder.Default
    private UUID paymentUuid = UUID.randomUUID();
    private PaymentType paymentType;
    private Double value;

}