package deliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class CheckOrderStatusCommand {

    private String orderId;
    private String status;
}
