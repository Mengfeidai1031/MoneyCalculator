package software.ulpgc.moneycalculator.architecture.control;

import software.ulpgc.moneycalculator.architecture.view.CalculatorDisplay;

public class ExchangeController {
    private final CalculatorDisplay view;

    public ExchangeController(CalculatorDisplay view) {
        this.view = view;

        view.exchange(e -> exchange());
    }

    private void exchange() {
        ExchangeCommand command = new ExchangeCommand(view);
        command.execute();
    }
}
