package numbersgenerator;

import java.time.Clock;

public class NumbersGeneratorFacadeConfiguration {

    NumbersGeneratorFacade createModuleForTests(Clock clock) {
        Draw draw = new Draw(clock);
        return new NumbersGeneratorFacade(draw);
    }
}
