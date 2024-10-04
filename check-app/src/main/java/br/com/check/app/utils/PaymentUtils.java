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
                .paymentUuid(isNull(paymentDto.getPaymentId()) ? UUID.randomUUID() : paymentDto.getPaymentId())
                .value(paymentDto.getValue())
                .paymentType(paymentDto.getPaymentType())
                .build();
    }

    public PaymentDto convertEntityToDto(Payment payment) {
        return PaymentDto.builder()
                .paymentId(payment.getPaymentUuid())
                .value(payment.getValue())
                .paymentType(payment.getPaymentType())
                .build();
    }
}
