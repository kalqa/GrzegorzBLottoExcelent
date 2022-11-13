package numbersgenerator.dto;

import java.time.LocalDateTime;
import java.util.List;

public record NumbersGeneratorResultDto(LocalDateTime drawDate, List<Integer> numbers) {

}
