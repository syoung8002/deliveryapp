package deliveryapp.infra;

import deliveryapp.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "/orders/addreviewandrating",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Order addReviewAndRating(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody AddReviewAndRatingCommand addReviewAndRatingCommand
    ) throws Exception {
        System.out.println("##### /order/addReviewAndRating  called #####");
        Order order = new Order();
        order.addReviewAndRating(addReviewAndRatingCommand);
        orderRepository.save(order);
        return order;
    }
}
//>>> Clean Arch / Inbound Adaptor
