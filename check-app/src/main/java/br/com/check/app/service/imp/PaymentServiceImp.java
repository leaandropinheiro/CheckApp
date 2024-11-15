package br.com.check.app.service.imp;

import br.com.check.app.dto.PaymentDto;
import br.com.check.app.entity.Payment;
import br.com.check.app.repository.PaymentRepository;
import br.com.check.app.service.PaymentService;
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
    public Payment createPayment(Payment payment, Double value) {

        Payment savedPayment = Payment.builder()
                .id(isNull(payment.getId()) ? UUID.randomUUID() : payment.getId())
                .value(value)
                .paymentType(payment.getPaymentType())
                .build();

        paymentRepository.save(savedPayment);

        return savedPayment;
    }
}
