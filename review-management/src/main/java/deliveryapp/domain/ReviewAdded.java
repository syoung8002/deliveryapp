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

    private String reviewId;
    private String orderId;
    private String review;

    public ReviewAdded(Review aggregate) {
        super(aggregate);
    }

    public ReviewAdded() {
        super();
    }
}
//>>> DDD / Domain Event
