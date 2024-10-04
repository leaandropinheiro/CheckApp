package br.com.check.app.service;

import br.com.check.app.dto.PaymentDto;
import br.com.check.app.entity.Payment;
import org.springframework.stereotype.Service;

@Service

public interface PaymentService {

    Payment createPayment(Payment payment, Double value);

}
