package kf.listener;

import kf.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@RequiredArgsConstructor
@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraud(Payment payment) {
        log.info("[Payment] Validating fraud...");
        sleep(2000);

        log.info("[Payment] Payment approved!");
        sleep(2000);

        log.info("[Payment] Payment ::: {}", payment);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(Payment payment) {
        log.info("[PDF] Generating PDF...");
        sleep(3000);
        log.info("[PDF] PDF ::: {}", payment);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail(Payment payment) {
        log.info("[EMAIL] Sending confirmation email...");
        log.info("[EMAIL] Email ::: {}", payment);
    }
}
