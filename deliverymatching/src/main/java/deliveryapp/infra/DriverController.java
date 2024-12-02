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
// @RequestMapping(value="/drivers")
@Transactional
public class DriverController {

    @Autowired
    DriverRepository driverRepository;

    @RequestMapping(
        value = "/drivers/orderaccept",
        method = RequestMethod.POST,
        produces = "application/json;charset=UTF-8"
    )
    public Driver orderAccept(
        HttpServletRequest request,
        HttpServletResponse response,
        @RequestBody OrderAcceptCommand orderAcceptCommand
    ) throws Exception {
        System.out.println("##### /driver/orderAccept  called #####");
        Driver driver = new Driver();
        driver.orderAccept(orderAcceptCommand);
        driverRepository.save(driver);
        return driver;
    }
}
//>>> Clean Arch / Inbound Adaptor
