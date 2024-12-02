package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderPaymentCompleted extends AbstractEvent {

    private String paymentId;
    private Money amount;
    private String paymentMethod;
    private PaymentMethodType paymentMethodType;
    private OrderId orderId;

    public OrderPaymentCompleted(Payment aggregate) {
        super(aggregate);
    }

    public OrderPaymentCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
