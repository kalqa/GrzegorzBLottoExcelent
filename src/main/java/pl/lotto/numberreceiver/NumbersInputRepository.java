package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.dto.TicketsForGivenDateDto;

import java.time.LocalDateTime;

public interface NumbersInputRepository {

    void save(LotteryTicket lotteryTicket);

    TicketsForGivenDateDto findAllByDate(LocalDateTime date);

    TicketsForGivenDateDto findAll();
}
