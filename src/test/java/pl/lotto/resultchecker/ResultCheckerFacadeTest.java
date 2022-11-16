package pl.lotto.resultchecker;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;

public class ResultCheckerFacadeTest {

    @Test
    public void f(){
        // given
        NumbersGeneratorFacade generator = Mockito.mock(NumbersGeneratorFacade.class);
        when(generator.winningNumbers()).thenReturn(List.of(1,2,3,4,5,6));



        // when
        ResultCheckerFacade facade = new ResultCheckerFacade(generator);
    }
}
