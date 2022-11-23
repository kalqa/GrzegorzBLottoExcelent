package pl.lotto.resultannouncer;

import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.ResultCheckerFacade;

import java.util.UUID;
import pl.lotto.resultchecker.TicketResult;

public class ResultAnnouncerFacade {

    ResultCheckerFacade resultCheckerFacade;

    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade) {
        this.resultCheckerFacade = resultCheckerFacade;
    }

    public ResultAnnouncerDto checkTicket(UUID id) {
        TicketResult ticketResult = resultCheckerFacade.checkWinningsForGivenTicketId(id);
        return ResultAnnouncerMessage.summaryMessage(ticketResult);

    }



}
