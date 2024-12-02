package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderAssigned extends AbstractEvent {

    private String driverId;
    private String driverName;
    private DateTime estimatedDeliveryTime;
    private OrderId orderId;

    public OrderAssigned(Driver aggregate) {
        super(aggregate);
    }

    public OrderAssigned() {
        super();
    }
}
//>>> DDD / Domain Event
