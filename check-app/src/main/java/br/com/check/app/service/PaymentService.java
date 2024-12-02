package br.com.check.app.service;

import br.com.check.app.dto.PaymentDto;
import br.com.check.app.entity.Payment;
import br.com.check.app.entity.enums.PaymentStatus;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service

public interface PaymentService {

    Payment createPayment(Payment payment);

//    void updatePaymentStatus(PaymentDto payment, PaymentStatus status);
}
