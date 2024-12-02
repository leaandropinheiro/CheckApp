package br.com.check.app.dto;

import br.com.check.app.entity.enums.PaymentStatus;
import br.com.check.app.entity.enums.PaymentType;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link br.com.check.app.entity.Payment}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PaymentDto implements Dto<PaymentDto> {
    private UUID paymentId;
    private PaymentStatus status;
    private PaymentType type;
    private Double value;
}