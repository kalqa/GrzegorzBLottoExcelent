package pl.lotto.numberreceiver;

import java.util.List;

public class NumberReceiverFacade {

    public static final String FAILED_MESSAGE = "failed";
    public static final String SUCCESS_MESSAGE = "success";

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        int size = numbersFromUser.size();
        NumberInputValidator validator = new NumberInputValidator();
        if (!validator.doesUserGaveSixNumbers(size)) {
            return new NumberReceiverResultDto(FAILED_MESSAGE);
        }
        return new NumberReceiverResultDto(SUCCESS_MESSAGE);
    }
}
