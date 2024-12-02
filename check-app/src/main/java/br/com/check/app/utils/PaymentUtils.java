package br.com.check.app.utils;

import br.com.check.app.dto.PaymentDto;
import br.com.check.app.entity.Payment;
import lombok.experimental.UtilityClass;

import java.util.UUID;

import static java.util.Objects.isNull;

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
