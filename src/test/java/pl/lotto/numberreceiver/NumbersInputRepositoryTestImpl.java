package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.dto.TicketsForGivenDateDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class NumbersInputRepositoryTestImpl implements NumbersInputRepository {

    Map<UUID, LotteryTicket> database = new ConcurrentHashMap<>();

    @Override
    public void save(LotteryTicket lotteryTicket) {
        database.put(lotteryTicket.uuid, lotteryTicket);
    }

    @Override
    public TicketsForGivenDateDto findAllByDate(LocalDateTime date) {
        List<List<Integer>> numbers = database.values()
                .stream()
                .filter(lotteryTicket -> lotteryTicket.nearestDrawDate.isEqual(date))
                .map(lotteryTicket -> lotteryTicket.numbersFromUser)
                .collect(Collectors.toList());
        return new TicketsForGivenDateDto(numbers);
    }

    @Override
    public TicketsForGivenDateDto findAll() {
        List<List<Integer>> numbers = database.values()
                .stream()
                .map(lotteryTicket -> lotteryTicket.numbersFromUser)
                .collect(Collectors.toList());
        return new TicketsForGivenDateDto(numbers);
    }
}
