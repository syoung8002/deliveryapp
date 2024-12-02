package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderStatusChecked extends AbstractEvent {

    private String orderId;
    private String status;

    public OrderStatusChecked(Order aggregate) {
        super(aggregate);
    }

    public OrderStatusChecked() {
        super();
    }
}
//>>> DDD / Domain Event
