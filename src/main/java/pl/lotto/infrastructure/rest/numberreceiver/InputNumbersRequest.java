package pl.lotto.infrastructure.rest.numberreceiver;

import java.util.List;

public class InputNumbersRequest {

    List<Integer> numbers;

    InputNumbersRequest(List<Integer> numbers) {
        this.numbers = numbers;
    }

    List<Integer> getNumbers() {
        return numbers;
    }
}
