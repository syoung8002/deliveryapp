package deliveryapp.domain;

import deliveryapp.PaymentProcessingApplication;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
//<<< DDD / Aggregate Root
public class Payment {

    @Id
    private String paymentId;

    @Embedded
    private Money amount;

    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethodType;

    @Embedded
    private OrderId orderId;

    @PrePersist
    public void onPrePersist() {}

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentProcessingApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    //<<< Clean Arch / Port Method
    public void completePayment(CompletePaymentCommand completePaymentCommand) {
        //implement business logic here:

        OrderPaymentCompleted orderPaymentCompleted = new OrderPaymentCompleted(
            this);
        orderPaymentCompleted.setOrderId(completePaymentCommand.getOrderId());
        orderPaymentCompleted.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
