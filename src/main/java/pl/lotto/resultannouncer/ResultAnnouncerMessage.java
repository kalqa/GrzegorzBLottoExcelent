package pl.lotto.resultannouncer;

import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.TicketResult;

class ResultAnnouncerMessage {

    static ResultAnnouncerDto summaryMessage(TicketResult ticketResult) {
        int hitNumbers = ticketResult.getHitNumbers().size();
        String message = createMessage(hitNumbers);
        return ResultAnnouncerDto.builder()
                .tickedId(ticketResult.getTickedId())
                .lotteryDate(ticketResult.getLotteryDate())
                .winningNumbers(ticketResult.getWinningNumbers())
                .userNumbers(ticketResult.getUserNumbers())
                .hitNumbers(ticketResult.getHitNumbers())
                .message(message)
                .build();
    }

    private static String createMessage(int hitNumbers) {
//        if (hitNumbers == 6) {
//            return "Congratulations!! You hit the jackpot!!";
//        }
//        if (hitNumbers >= 1 && hitNumbers <= 5) {
//            return "Congratulations!! You hit " + hitNumbers + " numbers";
//        }
//        if (hitNumbers == 0) {
//            return "You didn't hit any numbers. Try again";
//        }

        switch (hitNumbers) {
            case 6: {
                return "Congratulations!! You hit the jackpot!!";
            }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                return "Congratulations!! You hit " + hitNumbers + " numbers";
            }
            case 0: {
                return "You didn't hit any numbers. Try again";
            }
            default: {
                throw new IllegalStateException("hit numbers was:" + hitNumbers);
            }
        }
    }
}
