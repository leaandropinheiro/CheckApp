package br.com.check.app.dto;

import br.com.check.app.entity.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link br.com.check.app.entity.Payment}
 */
@AllArgsConstructor
@Getter
public class PaymentDto implements Serializable {
    private UUID paymentId;
    private PaymentType paymentType;
    private Double value;
}