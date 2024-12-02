package deliveryapp.infra;

import deliveryapp.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "eventCollectors",
    path = "eventCollectors"
)
public interface EventCollectorRepository
    extends PagingAndSortingRepository<EventCollector, Long> {}