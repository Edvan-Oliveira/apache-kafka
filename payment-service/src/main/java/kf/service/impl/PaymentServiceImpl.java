package kf.service.impl;

import kf.model.Payment;
import kf.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("PaymentServiceImpl ::: Payment received: {}", payment);
        Thread.sleep(1000);

        log.info("PaymentServiceImpl ::: Sending payment...");
        kafkaTemplate.send("payment-topic", payment);
    }
}
