package kf.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("str-topic", message)
                .whenComplete((success, exception) -> {
                    if (exception == null) {
                        RecordMetadata recordMetadata = success.getRecordMetadata();
                        log.info("Message sent successful {}", message);
                        log.info("Partition {}, Offset {}", recordMetadata.partition(), recordMetadata.offset());
                    } else {
                        log.error("Error sending message");
                    }
                });
    }
}
