package pl.lotto.numberreceiver;

public class NumberReceiverResultDto {
    String message;

    NumberReceiverResultDto(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}
