package deliveryapp.domain;

import deliveryapp.OrdermanagementApplication;
import deliveryapp.domain.OrderPlaced;
import deliveryapp.domain.OrderStatusChecked;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    private String orderId;

    private String foodType;

    private Integer quantity;

    private String specialRequest;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderStatusChecked orderStatusChecked = new OrderStatusChecked(this);
        orderStatusChecked.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrdermanagementApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void checkOrderStatus(
        CheckOrderStatusCommand checkOrderStatusCommand
    ) {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void addReviewAndRating(
        AddReviewAndRatingCommand addReviewAndRatingCommand
    ) {
        //implement business logic here:

        ReviewAdded reviewAdded = new ReviewAdded(this);
        reviewAdded.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
