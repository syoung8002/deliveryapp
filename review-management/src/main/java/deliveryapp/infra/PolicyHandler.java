package deliveryapp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ReviewRepository reviewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReviewAdded'"
    )
    public void wheneverReviewAdded_WriteReview(
        @Payload ReviewAdded reviewAdded
    ) {
        ReviewAdded event = reviewAdded;
        System.out.println(
            "\n\n##### listener WriteReview : " + reviewAdded + "\n\n"
        );

        // Sample Logic //
        Review.writeReview(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
