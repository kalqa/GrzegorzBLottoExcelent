package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NumberReceiverFacade {

    public static final String FAILED_MESSAGE = "failed";
    public static final String SUCCESS_MESSAGE = "success";

    private final NumberInputValidator validator;


    NumberReceiverFacade(NumberInputValidator validator) {
        this.validator = validator;
    }

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        int size = numbersFromUser.size();
        List<String> validate = validator.validate(numbersFromUser);
        if (validate.isEmpty()) {
            LocalDateTime now = LocalDateTime.now();
            UUID uuid = UUID.randomUUID();
            uuid.toString();
            return new NumberReceiverResultDto(SUCCESS_MESSAGE, now);
        }
        String erorrsMessage = String.join(",", validate);
        return new NumberReceiverResultDto(erorrsMessage, null);
//        if (!validator.doesUserGaveSixNumbers(size)) {
//            return new NumberReceiverResultDto(FAILED_MESSAGE);
//        } else if (!validator.doesUserGaveVariousNumbers(numbersFromUser)) {
//            return new NumberReceiverResultDto(FAILED_MESSAGE);
//        } else if (!validator.doesUserGaveNumbersInRange(numbersFromUser)) {
//            return new NumberReceiverResultDto(FAILED_MESSAGE);
//        }
//        return new NumberReceiverResultDto(SUCCESS_MESSAGE);
    }
}
