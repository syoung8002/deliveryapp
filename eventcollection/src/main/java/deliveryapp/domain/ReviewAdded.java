package deliveryapp.domain;

import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ReviewAdded extends AbstractEvent {

    private String orderId;
    private String review;
    private Integer rating;
}
