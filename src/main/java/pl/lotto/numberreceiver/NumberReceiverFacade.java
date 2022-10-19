package pl.lotto.numberreceiver;

import java.util.List;

public class NumberReceiverFacade {

    public static final String FAILED_MESSAGE = "failed";
    public static final String SUCCESS_MESSAGE = "success";
    public static final int MAX_INPUT_NUMBERS_FROM_USER = 6;

    public NumberReceiverResultDto inputNumbers(List<Integer> numbersFromUser) {
        if(isLessThanSixNumbers(numbersFromUser)){
            return new NumberReceiverResultDto(FAILED_MESSAGE);
        }
        return new NumberReceiverResultDto(SUCCESS_MESSAGE);
    }

    private boolean isLessThanSixNumbers(List<Integer> numbersFromUser) {
        return numbersFromUser.size() < MAX_INPUT_NUMBERS_FROM_USER;
    }
}
