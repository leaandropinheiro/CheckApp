package br.com.check.app.service;

import br.com.check.app.dto.PaymentDto;
import org.springframework.stereotype.Service;

@Service

public interface PaymentService {

    void createPayment(PaymentDto payment);

}
