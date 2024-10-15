package kf.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.error("EXCEPTION HANDLER ::: Error caught");
        log.error("PAYLOAD ::: {}", message.getPayload());
        log.error("HEADERS ::: {}", message.getHeaders());
        log.error("OFFSET ::: {}", message.getHeaders().get("kafka_offset"));
        log.error("MSG_EXCEPTION ::: {}", exception.getMessage());
        return null;
    }
}
