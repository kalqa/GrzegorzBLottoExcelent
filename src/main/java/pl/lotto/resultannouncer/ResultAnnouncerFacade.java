package pl.lotto.resultannouncer;

import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;
import pl.lotto.resultchecker.ResultCheckerFacade;
import pl.lotto.resultchecker.TicketResult;

import java.util.UUID;

public class ResultAnnouncerFacade {

    ResultCheckerFacade resultCheckerFacade;
    ResultAnnouncerMessage resultAnnouncerMessage;


    public ResultAnnouncerFacade(ResultCheckerFacade resultCheckerFacade, ResultAnnouncerMessage resultAnnouncerMessage) {
        this.resultCheckerFacade = resultCheckerFacade;
        this.resultAnnouncerMessage = resultAnnouncerMessage;
    }

    public ResultAnnouncerDto checkTicket(UUID id) {
        TicketResult ticketResult = resultCheckerFacade.checkWinningsForGivenTicketId(id);
        return resultAnnouncerMessage.summaryMessage(ticketResult);

    }


}
