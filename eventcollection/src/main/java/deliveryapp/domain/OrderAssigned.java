package deliveryapp.domain;

import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderAssigned extends AbstractEvent {

    private String driverId;
    private String driverName;
    private DateTime estimatedDeliveryTime;
    private OrderId orderId;
}
