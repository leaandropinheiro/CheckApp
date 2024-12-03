package br.com.check.app.entity;

import br.com.check.app.entity.enums.PaymentStatus;
import br.com.check.app.entity.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
    private PaymentStatus status;
    private PaymentType type;
    private Double value;

}