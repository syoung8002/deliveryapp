package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderStatusChecked extends AbstractEvent {

    private String orderId;
    private String status;
}
