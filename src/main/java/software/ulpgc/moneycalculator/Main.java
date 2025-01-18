package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.control.ExchangeController;
import software.ulpgc.moneycalculator.control.ApiService;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.view.MainFrame;
import java.util.List;

public class Main {
    private static final MainFrame mainFrame = new MainFrame();

    public static void main(String[] args) {
        List<Currency> currencies = new ApiService().load();
        new ExchangeController(mainFrame.display);
        display(currencies);
    }

    private static void display(List<Currency> currencies) {
        mainFrame.put(currencies);
        mainFrame.setVisible(true);
    }
}

