package deliveryapp.domain;

import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class OrderPaymentCompleted extends AbstractEvent {

    private String paymentId;
    private Money amount;
    private String paymentMethod;
    private paymentMethodType paymentMethodType;
    private OrderId orderId;
}
