package software.ulpgc.moneycalculator.architecture.view;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import javax.swing.*;
import java.util.List;

public class MainFrame extends JFrame {
    public final CalculatorDisplay display;

    public MainFrame(){
        setTitle("Money Calculator");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        display = new CalculatorDisplay();

        add(display);
    }

    public void put(List<Currency> currencies) {
        display.display(currencies);
    }
}