package br.com.check.app.entity;


import br.com.check.app.entity.enums.PaymentType;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Payment extends AbstractEntity<Payment>{

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    private PaymentType paymentType;
    private Double value;

}