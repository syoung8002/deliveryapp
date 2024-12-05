package deliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommand {

    private String orderId;
    private String foodType;
    private String specialRequest;
    private Integer quantity;
}
