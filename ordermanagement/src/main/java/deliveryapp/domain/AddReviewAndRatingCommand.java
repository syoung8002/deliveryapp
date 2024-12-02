package deliveryapp.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class AddReviewAndRatingCommand {

    private String orderId;
    private String review;
    private Integer rating;
}
