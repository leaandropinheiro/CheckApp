package br.com.check.app.dto;

import br.com.check.app.entity.enums.PaymentStatus;
import br.com.check.app.entity.enums.PaymentType;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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