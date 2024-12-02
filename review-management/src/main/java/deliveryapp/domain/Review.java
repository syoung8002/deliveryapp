package deliveryapp.domain;

import deliveryapp.ReviewManagementApplication;
import deliveryapp.domain.ReviewAdded;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Review_table")
@Data
//<<< DDD / Aggregate Root
public class Review {

    @Id
    private String reviewId;

    private String orderId;

    private String review;

    @PostPersist
    public void onPostPersist() {
        ReviewAdded reviewAdded = new ReviewAdded(this);
        reviewAdded.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static ReviewRepository repository() {
        ReviewRepository reviewRepository = ReviewManagementApplication.applicationContext.getBean(
            ReviewRepository.class
        );
        return reviewRepository;
    }

    //<<< Clean Arch / Port Method
    public static void writeReview(ReviewAdded reviewAdded) {
        //implement business logic here:

        /** Example 1:  new item 
        Review review = new Review();
        repository().save(review);

        */

        /** Example 2:  finding and process
        
        repository().findById(reviewAdded.get???()).ifPresent(review->{
            
            review // do something
            repository().save(review);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
