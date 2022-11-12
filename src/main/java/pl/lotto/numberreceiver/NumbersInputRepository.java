package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.dto.TicketsForGivenDateDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface NumbersInputRepository {

    void save(LotteryTicket lotteryTicket);

    TicketsForGivenDateDto findAllByDate(LocalDateTime date);

    TicketsForGivenDateDto findAll();
}
