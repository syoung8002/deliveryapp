package deliveryapp.infra;

import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EventCollectorViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private EventCollectorRepository eventCollectorRepository;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderStatusChecked_then_CREATE_1(
        @Payload OrderStatusChecked orderStatusChecked
    ) {
        try {
            if (!orderStatusChecked.validate()) return;

            // timestamp
            Date date = new Date();
            String timestamp = format.format(date);

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType("OrderStatusChecked");
            eventCollector.setCorrelationKey(orderStatusChecked.getOrderId());
            eventCollector.setTimestamp(timestamp);
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

            Date date = new Date();
            String timestamp = format.format(date);
            
            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType("OrderAssigned");
            eventCollector.setCorrelationKey(
                String.valueOf(orderAssigned.getOrderId())
            );
            eventCollector.setPayload(orderAssigned.toString());
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

            Date date = new Date();
            String timestamp = format.format(date);

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType("OrderPaymentCompleted");
            eventCollector.setCorrelationKey(
                String.valueOf(orderPaymentCompleted.getOrderId())
            );
            eventCollector.setPayload(orderPaymentCompleted.toString());
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

            Date date = new Date();
            String timestamp = format.format(date);

            // view 객체 생성
            EventCollector eventCollector = new EventCollector();
            // view 객체에 이벤트의 Value 를 set 함
            eventCollector.setType("ReviewAdded");
            eventCollector.setCorrelationKey(reviewAdded.getOrderId());
            eventCollector.setPayload(reviewAdded.toString());
            eventCollector.setTimestamp(timestamp);
            // view 레파지 토리에 save
            eventCollectorRepository.save(eventCollector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
