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
        if(doesUserGaveSixNumbers(numbersFromUser.size())){
            validationErrors.add("not have six numbers");
        }
//        if(doesUserGaveSixNumbers(numbersFromUser)){
//            validationErrors.add("not have six numbers");
//        }
//        if(doesUserGaveSixNumbers(numbersFromUser)){
//            validationErrors.add("not have six numbers");
//        }
//        validationErrors.isEmpty();
        return validationErrors;
    }

    private boolean doesUserGaveSixNumbers(int size) {
        return size == MAX_INPUT_NUMBERS_FROM_USER;
    }

    private boolean doesUserGaveVariousNumbers(List<Integer> numbers) {
//        Set<Integer> setWithoutDuplicates = new HashSet<>();
        List<Integer> integers = numbers.stream().distinct().toList();
        return hasDuplicates(integers);
//        if(integers.size() != 6){
//            return false;
//        }
//        re
//        for (int number : numbers) {
//            if (!setWithoutDuplicates.add(number)) {
//                return false;
//            }
//        }
//        return true;
    }

    private boolean hasDuplicates(List<Integer> integers) {
        return integers.size() == 6;
    }

    private boolean doesUserGaveNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isNumberInRange);

//        for (int n : numbers) {
//            if (isNumberInRange(n)) {
//                return false;
//            }
//        }
//        return true;
    }

    private boolean isNumberInRange(int n) {
        return n < MIN_VALUE_IN_INPUT_NUMBERS_FROM_USER || n > MAX_VALUE_IN_INPUT_NUMBERS_FROM_USER;
    }
}
