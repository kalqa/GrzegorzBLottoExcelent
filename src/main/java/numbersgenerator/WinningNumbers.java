package numbersgenerator;

import java.time.LocalDateTime;
import java.util.List;

class WinningNumbers {
    LocalDateTime date;
    List<Integer> numbers;

    WinningNumbers(LocalDateTime date, List<Integer> numbers) {
        this.date = date;
        this.numbers = numbers;
    }
}
