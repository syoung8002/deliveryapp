package deliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CompletePaymentCommand {

    private String paymentId;
    private Money amount;
    private String paymentMethod;
    private paymentMethodType paymentMethodType;
    private OrderId orderId;
}
