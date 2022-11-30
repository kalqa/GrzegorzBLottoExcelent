package pl.lotto.resultchecker;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResultCheckerRepository {

    void insertAll(List<TicketResult> list);

    List<TicketResult> findAllByDate(LocalDateTime date);

    TicketResult findById(UUID id);
}
