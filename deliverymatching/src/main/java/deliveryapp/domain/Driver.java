package deliveryapp.domain;

import deliveryapp.domain.OrderRejected;
import deliveryapp.DeliverymatchingApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Driver_table")
@Data

//<<< DDD / Aggregate Root
public class Driver  {


    
    @Id
    private String driverId;
    
    private String name;
    
    @Embedded
    private OrderId orderId;

    @PostPersist
    public void onPostPersist(){
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist(){
    }

    public static DriverRepository repository(){
        DriverRepository driverRepository = DeliverymatchingApplication.applicationContext.getBean(DriverRepository.class);
        return driverRepository;
    }



//<<< Clean Arch / Port Method
    public void orderAccept(OrderAcceptCommand orderAcceptCommand){
        //implement business logic here:
       
        OrderAssigned orderAssigned = new OrderAssigned(this);
        orderAssigned.setOrderId(orderAcceptCommand.getOrderId());
        orderAssigned.publishAfterCommit();
    }
//>>> Clean Arch / Port Method



}
//>>> DDD / Aggregate Root
