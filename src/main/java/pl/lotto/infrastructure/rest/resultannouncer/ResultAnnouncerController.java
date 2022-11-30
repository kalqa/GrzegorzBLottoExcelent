package pl.lotto.infrastructure.rest.resultannouncer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.lotto.resultannouncer.ResultAnnouncerFacade;
import pl.lotto.resultannouncer.dto.ResultAnnouncerDto;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class ResultAnnouncerController {

    private final ResultAnnouncerFacade resultAnnouncerFacade;

    @GetMapping("/winners/{uniqueId}")
    public ResponseEntity<ResultAnnouncerDto> getWinningNumbers(@PathVariable UUID uniqueId) {
        ResultAnnouncerDto resultAnnouncerDto = resultAnnouncerFacade.checkTicket(uniqueId);
        return ResponseEntity.ok(resultAnnouncerDto);
    }


}
