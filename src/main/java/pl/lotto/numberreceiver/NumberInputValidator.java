package pl.lotto.numberreceiver;

class NumberInputValidator {
    public static final int MAX_INPUT_NUMBERS_FROM_USER = 6;

    public boolean doesUserGaveSixNumbers(int size) {
        return size == MAX_INPUT_NUMBERS_FROM_USER;
    }
}
