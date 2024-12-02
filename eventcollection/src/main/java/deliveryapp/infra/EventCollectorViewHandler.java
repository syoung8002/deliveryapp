package deliveryapp.infra;

import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EventCollectorViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private EventCollectorRepository eventCollectorRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderStatusChecked_then_CREATE_1(
        @Payload OrderStatusChecked orderStatusChecked
    ) {
        try {
            if (!orderStatusChecked.validate()) return;

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType(OrderStatusChecked);
            eventCollector.setCorrelationKey(orderStatusChecked.getOrderId());
            eventCollector.setTimestamp(timestamp);
            eventCollector.setPayload(OrderStatusChecked);
            // view 레파지 토리에 save
            eventCollectorRepository.save(eventCollector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAssigned_then_CREATE_2(
        @Payload OrderAssigned orderAssigned
    ) {
        try {
            if (!orderAssigned.validate()) return;

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType(OrderAssigned);
            eventCollector.setCorrelationKey(
                String.valueOf(orderAssigned.getOrderId())
            );
            eventCollector.setPayload(OrderAssigned);
            eventCollector.setTimestamp(timestamp);
            // view 레파지 토리에 save
            eventCollectorRepository.save(eventCollector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPaymentCompleted_then_CREATE_3(
        @Payload OrderPaymentCompleted orderPaymentCompleted
    ) {
        try {
            if (!orderPaymentCompleted.validate()) return;

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType(OrderPaymentCompleted);
            eventCollector.setCorrelationKey(
                String.valueOf(orderPaymentCompleted.getOrderId())
            );
            eventCollector.setPayload(OrderPaymentCompleted);
            eventCollector.setTimestamp(timestamp);
            // view 레파지 토리에 save
            eventCollectorRepository.save(eventCollector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReviewAdded_then_CREATE_4(
        @Payload ReviewAdded reviewAdded
    ) {
        try {
            if (!reviewAdded.validate()) return;

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType(ReviewAdded);
            eventCollector.setCorrelationKey(reviewAdded.getOrderId());
            eventCollector.setPayload(ReviewAdded);
            eventCollector.setTimestamp(timestamp);
            // view 레파지 토리에 save
            eventCollectorRepository.save(eventCollector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
