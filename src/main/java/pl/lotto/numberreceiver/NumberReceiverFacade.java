package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static pl.lotto.numberreceiver.NumberReceiverResultDto.failure;
import static pl.lotto.numberreceiver.NumberReceiverResultDto.success;

public class NumberReceiverFacade {

    private final NumberInputValidator validator;

    NumberReceiverFacade(NumberInputValidator validator) {
        this.validator = validator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        NumberReciverInputError validate = validator.validate(numbersFromUser);
        if (!validate.isError()) {
            return failure(validate.getMessage());
        }
        LocalDateTime nearestDrawDate = DrawDatesFinder.upcomingDrawDate();
        UUID uuid = UUID.randomUUID();
        String userLotteryId = uuid.toString();
        return success(nearestDrawDate, userLotteryId);
    }


}
