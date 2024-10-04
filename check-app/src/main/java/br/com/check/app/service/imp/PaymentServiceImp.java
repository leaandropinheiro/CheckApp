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

        log.info("PaymentService.createPayment() -> init process, payment {}",payment);

        Payment savedPayment = Payment.builder()
                .paymentId(isNull(payment.getPaymentId()) ? UUID.randomUUID() : payment.getPaymentId())
                .value(value)
                .paymentType(payment.getPaymentType())
                .build();

        //implementacao futura, para pagamento com cartoes e pix --> da pra fazer por comando e switch

        paymentRepository.save(savedPayment);

        return savedPayment;
    }
}
