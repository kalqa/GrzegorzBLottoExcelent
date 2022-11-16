package pl.lotto.numberreceiver;

import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import pl.lotto.numberreceiver.dto.TicketsForGivenDateDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static pl.lotto.numberreceiver.dto.NumberReceiverResultDto.failure;
import static pl.lotto.numberreceiver.dto.NumberReceiverResultDto.success;

public class NumberReceiverFacade {

    private final NumberInputValidator validator;
    private final DrawDatesFinder drawDatesFinder;
    private final NumbersInputRepository repository;

    NumberReceiverFacade(NumberInputValidator validator, DrawDatesFinder drawDatesFinder, NumbersInputRepository repository) {
        this.validator = validator;
        this.drawDatesFinder = drawDatesFinder;
        this.repository = repository;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberReciverInputError validate = validator.validate(numbersFromUser);
        if (validate.isError()) {
            return failure(validate.getMessage());
        }
        LocalDateTime nearestDrawDate = drawDatesFinder.upcomingDrawDate();
        UUID uuid = UUID.randomUUID();
        String userLotteryId = uuid.toString();
        LotteryTicket lotteryTicket = new LotteryTicket(uuid, nearestDrawDate, numbersFromUser);
        repository.save(lotteryTicket);
        return success(nearestDrawDate, userLotteryId);
    }

    TicketsForGivenDateDto retrieveAllNumbersForGivenDate(LocalDateTime date) {
        return repository.findAllByDate(date);
    }
}
