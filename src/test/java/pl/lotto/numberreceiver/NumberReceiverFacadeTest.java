package pl.lotto.numberreceiver;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberReceiverFacadeTest {

    @Test
    @DisplayName("should return success message when user gave six various numbers")
    public void should_return_success_message_when_user_gave_six_various_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getMessage()).isEqualTo("success");
    }

    @Test
    @DisplayName("should return failed message when user gave less than six numbers")
    public void should_return_failed_message_when_user_gave_less_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getMessage()).isEqualTo("failed");
    }

    @Test
    @DisplayName("should return failed message when user gave more than six numbers")
    public void should_return_failed_message_when_user_gave_more_than_six_numbers() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6, 7);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getMessage()).isEqualTo("failed");
    }

    @Test
    @DisplayName("should return failed message when user gave same number")
    public void should_return_failed_message_when_user_gave_same_number() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 1, 2, 3, 4, 5);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getMessage()).isEqualTo("failed");
    }

    @Test
    @DisplayName("should return failed message when user gave number out of range")
    public void should_return_failed_message_when_user_gave_number_out_of_range() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 222);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getMessage()).isEqualTo("failed");
    }

    @Test
    @DisplayName("should return success message when user gave number in range")
    public void should_return_success_message_when_user_gave_number_in_range() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 88);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getMessage()).isEqualTo("success");
    }

    @Test
    @DisplayName("should return success message with next saturday drawDate when user gave numbers")
    public void sssss() {
        // given
        NumberReceiverFacade numberReceiverFacade = new NumberReceiverFacadeConfiguration().createModuleForTests();
        List<Integer> numbersFromUser = List.of(1, 2, 3, 4, 5, 6);
        // when
        NumberReceiverResultDto result = numberReceiverFacade.inputNumbers(numbersFromUser);
        // then
        assertThat(result.getMessage()).isEqualTo("success");
//        assertThat(result.getDrawTime()).isEqualTo();
    }

}
