package kf.resource.impl;

import kf.model.Payment;
import kf.resource.PaymentResource;
import kf.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentResourceImpl implements PaymentResource {

    private final PaymentService paymentService;

    @Override
    public ResponseEntity<Void> payment(Payment payment) {
        paymentService.sendPayment(payment);
        return ResponseEntity.ok().build();
    }
}
