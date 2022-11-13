package numbersgenerator;

import numbersgenerator.dto.NumbersGeneratorResultDto;


public class NumbersGeneratorFacade {

    private final Draw draw;
    private final NumbersGeneratorRepository numbersGeneratorRepository;

    WinningNumbers winningNumbers;

    NumbersGeneratorFacade(Draw draw, NumbersGeneratorRepository numbersGeneratorRepository) {
        this.draw = draw;
        this.numbersGeneratorRepository = numbersGeneratorRepository;
    }

    NumbersGeneratorResultDto generateNumbers() {
        winningNumbers = draw.startDrew();
        numbersGeneratorRepository.save(winningNumbers);
        return new NumbersGeneratorResultDto(winningNumbers.date, winningNumbers.numbers);
    }


}

