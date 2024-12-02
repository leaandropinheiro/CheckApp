package br.com.check.app.service.imp;

import br.com.check.app.dto.PaymentDto;
import br.com.check.app.entity.Payment;
import br.com.check.app.entity.enums.PaymentStatus;
import br.com.check.app.repository.PaymentRepository;
import br.com.check.app.service.PaymentService;
import br.com.check.app.utils.PaymentUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentServiceImp implements PaymentService {

    private PaymentRepository paymentRepository;


    @Override
    public Payment createPayment(Payment payment) {

        Payment savedPayment = Payment.builder()
                .id(isNull(payment.getId()) ? UUID.randomUUID() : payment.getId())
                .value(isNull(payment.getValue()) ? null : payment.getValue())
                .status(isNull(payment.getStatus()) ? PaymentStatus.PAYMENT_PENDING : payment.getStatus())
                .type(payment.getType())
                .build();

        this.paymentRepository.save(savedPayment);

        return savedPayment;
    }

//    @Override
//    public void updatePaymentStatus(PaymentDto payment, PaymentStatus status) {
//
//        payment.setStatus(status);
//        this.paymentRepository.save(PaymentUtils.convertDtoToEntity(payment));
//    }
}
