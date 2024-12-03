package br.com.check.app.utils;

import static java.util.Objects.isNull;

import br.com.check.app.dto.PaymentDto;
import br.com.check.app.entity.Payment;
import java.util.UUID;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PaymentUtils {

    public static Payment convertDtoToEntity(PaymentDto paymentDto) {
        return Payment.builder()
                .id(isNull(paymentDto.getPaymentId()) ? UUID.randomUUID() : paymentDto.getPaymentId())
                .value(paymentDto.getValue())
                .status(paymentDto.getStatus())
                .type(paymentDto.getType())
                .build();
    }

    public PaymentDto convertEntityToDto(Payment payment) {
        return PaymentDto.builder()
                .paymentId(payment.getId())
                .value(payment.getValue())
                .status(payment.getStatus())
                .type(payment.getType())
                .build();
    }
}
