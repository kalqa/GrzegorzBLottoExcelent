package numbersgenerator;

import numbersgenerator.dto.NumbersGeneratorResultDto;


public class NumbersGeneratorFacade {

    private final Draw draw;

    NumbersGeneratorFacade(Draw draw) {
        this.draw = draw;
    }

    NumbersGeneratorResultDto winningNumbers() {
        return draw.startDrew();
    }

}

