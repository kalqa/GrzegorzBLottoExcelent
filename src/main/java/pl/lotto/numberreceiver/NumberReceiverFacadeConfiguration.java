package pl.lotto.numberreceiver;

public class NumberReceiverFacadeConfiguration {
    NumberReceiverFacade createModuleForTests() {
        NumberInputValidator validator = new NumberInputValidator();
        return new NumberReceiverFacade(validator);
    }



}
