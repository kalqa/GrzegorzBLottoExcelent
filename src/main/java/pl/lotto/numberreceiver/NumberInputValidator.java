package pl.lotto.numberreceiver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class NumberInputValidator {
    public static final int MAX_INPUT_NUMBERS_FROM_USER = 6;
    public static final int MIN_VALUE_IN_INPUT_NUMBERS_FROM_USER = 1;
    public static final int MAX_VALUE_IN_INPUT_NUMBERS_FROM_USER = 99;

    public boolean doesUserGaveSixNumbers(int size) {
        return size == MAX_INPUT_NUMBERS_FROM_USER;
    }

    public boolean doesUserGaveVariousNumbers(List<Integer> numbers) {
        Set<Integer> setWithoutDuplicates = new HashSet<>();
        for (int n : numbers) {
            if (!setWithoutDuplicates.add(n)) {
                return false;
            }
        }
        return true;
    }

    public boolean doesUserGaveNumbersInRange(List<Integer> numbers) {
        for (int n : numbers) {
            if (n < MIN_VALUE_IN_INPUT_NUMBERS_FROM_USER) {
                return false;
            } else if (n > MAX_VALUE_IN_INPUT_NUMBERS_FROM_USER) {
                return false;
            }
        }
        return true;
    }
}
