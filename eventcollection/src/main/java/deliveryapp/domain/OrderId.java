package deliveryapp.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//<<< DDD / Value Object
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderId {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

}
//>>> DDD / Value Object
