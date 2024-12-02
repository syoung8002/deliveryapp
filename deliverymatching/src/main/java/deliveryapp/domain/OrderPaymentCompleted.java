package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPaymentCompleted extends AbstractEvent {

    private String paymentId;
    private Object amount;
    private String paymentMethod;
    private Object paymentMethodType;
    private Object orderId;
}
