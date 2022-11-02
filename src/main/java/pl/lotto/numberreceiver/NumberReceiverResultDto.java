package pl.lotto.numberreceiver;

import java.time.LocalDateTime;

public class NumberReceiverResultDto {

    private NumberReciverInputError error;
    private LocalDateTime drawTime;
    private String userLotteryId;

    public NumberReceiverResultDto(NumberReciverInputError error, LocalDateTime drawTime, String userLotteryId) {
        this.error = error;
        this.drawTime = drawTime;
        this.userLotteryId = userLotteryId;
    }

    public NumberReceiverResultDto(NumberReciverInputError error) {
        this.error = error;
    }

    LocalDateTime getDrawTime() {
        return drawTime;
    }

    NumberReciverInputError getError() {
        return error;
    }

    void setError(NumberReciverInputError error) {
        this.error = error;
    }

    public String getUserLotteryId() {
        return userLotteryId;
    }

    public void setUserLotteryId(String userLotteryId) {
        this.userLotteryId = userLotteryId;
    }
}
