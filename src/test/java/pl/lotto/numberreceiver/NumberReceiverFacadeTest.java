package pl.lotto.numberreceiver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeTest {

    @Test
    @DisplayName("should return false when user gave six various numbers")
    public void should_return_false_when_user_gave_six_various_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getError().isError()).isFalse();
    }

    @Test
    @DisplayName("should return true when user gave less than six numbers")
    public void should_return_true_when_user_gave_less_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getError().isError()).isTrue();
        System.out.println(result.getError().getMessage());
    }

    @Test
    @DisplayName("should return true when user gave more than six numbers")
    public void should_return_true_when_user_gave_more_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getError().isError()).isTrue();
        System.out.println(result.getError().getMessage());
    }

    @Test
    @DisplayName("should return true when user gave same number")
    public void should_return_true_when_user_gave_same_number() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 1, 2, 3, 4, 5);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getError().isError()).isTrue();
        System.out.println(result.getError().getMessage());
    }

    @Test
    @DisplayName("should return true when user gave number out of range")
    public void should_return_true_when_user_gave_number_out_of_range() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 222);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getError().isError()).isTrue();
        System.out.println(result.getError().getMessage());
    }

    @Test
    @DisplayName("should return true and message with errors when user has made mistakes in input number")
    public void should_return_true_and_message_with_errors_when_user_has_made_mistakes_in_input_number() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 1, 3, 5, 222);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getError().isError()).isTrue();
        System.out.println(result.getError().getMessage());
    }

    @ParameterizedTest
    @MethodSource("createLotteryTicketDay")
    @DisplayName("should return false and message with next draw date when user gave numbers")
    public void should_return_false_and_message_with_next_draw_date_when_user_gave_numbers(LocalDateTime lotteryTicketDate) {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        DrawDatesFinder.TICKET_DATE = lotteryTicketDate;

        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        LocalDateTime upcomingDrewDate = result.getDrawTime();
        String upcomingDrewDateFormatted = DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy").format(upcomingDrewDate);

        // then
        assertThat(result.getError().isError()).isFalse();
        System.out.println(upcomingDrewDateFormatted);
    }

    private static Stream<Arguments> createLotteryTicketDay() {
        return Stream.of(
                Arguments.of(LocalDateTime.of(2022, 10, 17, 11, 0)),
                Arguments.of(LocalDateTime.of(2022, 10, 29, 11, 0)),
                Arguments.of(LocalDateTime.of(2022, 10, 29, 13, 0)),
                Arguments.of(LocalDateTime.now())
        );
    }

    @Test
    @DisplayName("should return false and message with lottery id when user gave number")
    public void should_return_false_and_message_with_lottery_id_when_user_gave_number() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        String userLotteryId = result.getUserLotteryId();
        // then
        assertThat(result.getError().isError()).isFalse();
        System.out.println(result.getUserLotteryId());
    }


}
