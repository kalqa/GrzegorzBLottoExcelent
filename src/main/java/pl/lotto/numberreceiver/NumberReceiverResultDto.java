package pl.lotto.numberreceiver;

import java.time.LocalDateTime;

public class NumberReceiverResultDto {
    String message;
    LocalDateTime drawTime;

    NumberReceiverResultDto(String message, LocalDateTime now) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }

    LocalDateTime getDrawTime() {
        return drawTime;
    }
}
