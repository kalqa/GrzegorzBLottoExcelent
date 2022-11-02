package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class NumberReceiverFacade {

    private final NumberInputValidator validator;

    NumberReceiverFacade(NumberInputValidator validator) {
        this.validator = validator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        List<String> validate = validator.validate(numbersFromUser);
        NumberReciverInputError inputNumbersError = new NumberReciverInputError();
        if (validate.isEmpty()) {
            LocalDateTime nearestDrawDate = DrawDatesFinder.upcomingDrawDate();
            UUID uuid = UUID.randomUUID();
            String userLotteryId = uuid.toString();
            inputNumbersError.setError(false);
            return new NumberReceiverResultDto(inputNumbersError, nearestDrawDate, userLotteryId);
        } else {
            String errorsMessage = validate.stream().collect(Collectors.joining(", ", "Input numbers error: ", ""));
            inputNumbersError.setError(true);
            inputNumbersError.setMessage(errorsMessage);
            return new NumberReceiverResultDto(inputNumbersError);
        }
    }
}
