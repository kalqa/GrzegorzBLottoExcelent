package pl.lotto.numberreceiver.dto;

import java.util.List;

public record TicketsForGivenDateDto(List<List<Integer>> allUsersNumbers) {

}
