package pl.lotto.numberreceiver;

import java.util.List;
import java.util.stream.Collectors;

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
            return new NumberReceiverResultDto(SUCCESS_MESSAGE);
        }
        String erorrsMessage = String.join(",", validate);
        return new NumberReceiverResultDto(erorrsMessage);
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
