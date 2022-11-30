package pl.lotto.infrastructure.rest.numbersgenerator.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;


public class GenratorScheduler {

    NumbersGeneratorFacade numbersGeneratorFacade;

//    @Scheduled("")
    public void f(){
        numbersGeneratorFacade.generateNumbers();
    }

}
