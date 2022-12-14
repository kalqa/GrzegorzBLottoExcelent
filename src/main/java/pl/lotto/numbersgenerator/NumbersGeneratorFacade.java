package pl.lotto.numbersgenerator;
import pl.lotto.numbersgenerator.dto.NumbersGeneratorResultDto;
import java.util.List;

public class NumbersGeneratorFacade {

    private final Draw draw;
    private final NumbersGeneratorRepository numbersGeneratorRepository;

    NumbersGeneratorFacade(Draw draw, NumbersGeneratorRepository numbersGeneratorRepository) {
        this.draw = draw;
        this.numbersGeneratorRepository = numbersGeneratorRepository;

    }

    NumbersGeneratorResultDto generateNumbers() {
        WinningNumbers winningNumbers = draw.startDrew();
        numbersGeneratorRepository.save(winningNumbers);
        return new NumbersGeneratorResultDto(winningNumbers.getDate(), winningNumbers.getNumbers());
    }

    List<WinningNumbers> getWinningNumbers() {
        return numbersGeneratorRepository.findAll();
    }
}

