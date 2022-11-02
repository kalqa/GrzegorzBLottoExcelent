package pl.lotto.numberreceiver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class NumberInputValidator {
    public static final int MAX_INPUT_NUMBERS_FROM_USER = 6;
    public static final int MIN_VALUE_IN_INPUT_NUMBERS_FROM_USER = 1;
    public static final int MAX_VALUE_IN_INPUT_NUMBERS_FROM_USER = 99;

    List<String> validationErrors = new LinkedList<>();

    public List<String> validate(List<Integer> numbersFromUser) {
        if (!doesUserGaveSixNumbers(numbersFromUser.size())) {
            validationErrors.add("not have six numbers");
        }
        if (!doesUserGaveVariousNumbers(numbersFromUser)) {
            validationErrors.add("not have various numbers");
        }
        if (!doesUserGaveNumbersInRange(numbersFromUser)) {
            validationErrors.add("numbers out off range");
        }
        return validationErrors;
    }

    private boolean doesUserGaveSixNumbers(int size) {
        return size == MAX_INPUT_NUMBERS_FROM_USER;
    }

    private boolean doesUserGaveVariousNumbers(List<Integer> numbers) {
        return numbers.stream().allMatch(new HashSet<>()::add);
    }

    private boolean doesUserGaveNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .noneMatch(this::isNumberOutOfRange);
    }

    private boolean isNumberOutOfRange(int n) {
        return n < MIN_VALUE_IN_INPUT_NUMBERS_FROM_USER || n > MAX_VALUE_IN_INPUT_NUMBERS_FROM_USER;
    }
}
