package software.ulpgc.moneycalculator.architecture.view;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import java.util.List;

public interface Display {
    void display(List<Currency> currencies);
}
