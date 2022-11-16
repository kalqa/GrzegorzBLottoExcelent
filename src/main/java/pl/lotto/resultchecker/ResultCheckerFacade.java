package pl.lotto.resultchecker;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;

public class ResultCheckerFacade {

    NumbersGeneratorFacade generator;
    NumberReceiverFacade receiverFacade;

    ResultCheckerFacade(NumbersGeneratorFacade generator, NumberReceiverFacade receiverFacade) {
        this.generator = generator;
        this.receiverFacade = receiverFacade;
    }

    public void f() {
        generator.winningNumbers();
        receiverFacade.allNumbers();



    }
}
