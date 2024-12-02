package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class ReviewAdded extends AbstractEvent {

    private String orderId;
    private String review;
    private Integer rating;

    public ReviewAdded(Order aggregate) {
        super(aggregate);
    }

    public ReviewAdded() {
        super();
    }
}
//>>> DDD / Domain Event
