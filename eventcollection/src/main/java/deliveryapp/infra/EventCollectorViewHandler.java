package deliveryapp.infra;

import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;
import java.io.IOException;
import java.util.Date;
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
            eventCollector.setType(orderStatusChecked.getEventType());
            eventCollector.setCorrelationKey(orderStatusChecked.getOrderId());
            eventCollector.setTimestamp(orderStatusChecked.getTimestamp());
            eventCollector.setPayload(orderStatusChecked.toString());
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
            eventCollector.setType(orderAssigned.getEventType());
            eventCollector.setCorrelationKey(String.valueOf(orderAssigned.getOrderId().getId()));
            eventCollector.setPayload(orderAssigned.toString());
            eventCollector.setTimestamp(orderAssigned.getTimestamp());
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
            eventCollector.setType(orderPaymentCompleted.getEventType());
            eventCollector.setCorrelationKey(String.valueOf(orderPaymentCompleted.getOrderId().getId()));
            eventCollector.setPayload(orderPaymentCompleted.toString());
            eventCollector.setTimestamp(orderPaymentCompleted.getTimestamp());
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
            eventCollector.setType(reviewAdded.getEventType());
            eventCollector.setCorrelationKey(String.valueOf(reviewAdded.getOrderId().getId()));
            eventCollector.setPayload(reviewAdded.toString());
            eventCollector.setTimestamp(reviewAdded.getTimestamp());
            // view 레파지 토리에 save
            eventCollectorRepository.save(eventCollector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_5(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType(OrderPlaced);
            eventCollector.setCorrelationKey(orderPlaced.getOrderId());
            eventCollector.setPayload(OrderPlaced);
            eventCollector.setTimestamp(timestamp);
            // view 레파지 토리에 save
            eventCollectorRepository.save(eventCollector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPaymentCompleted_then_CREATE_6(
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
    public void whenOrderAssigned_then_CREATE_7(
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
    //>>> DDD / CQRS
}
