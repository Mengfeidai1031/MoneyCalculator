package software.ulpgc.moneycalculator.apps.windows;

import software.ulpgc.moneycalculator.architecture.control.ExchangeController;
import software.ulpgc.moneycalculator.architecture.control.ApiServiceCurrencyLoader;
import software.ulpgc.moneycalculator.architecture.model.Currency;
import software.ulpgc.moneycalculator.architecture.view.MainFrame;
import java.util.List;

public class Main {
    private static final MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        List<Currency> currencies = new ApiServiceCurrencyLoader().load();
        new ExchangeController(mainFrame.display);
        display(currencies);
    }

    private static void display(List<Currency> currencies) {
        mainFrame.put(currencies);
        mainFrame.setVisible(true);
    }
}

