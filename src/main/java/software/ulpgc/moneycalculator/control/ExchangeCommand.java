package software.ulpgc.moneycalculator.control;

import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;
import software.ulpgc.moneycalculator.model.Money;
import software.ulpgc.moneycalculator.view.CalculatorDisplay;

public class ExchangeCommand implements Command {
    private final CalculatorDisplay view;

    public ExchangeCommand(CalculatorDisplay view) {
        this.view = view;
    }

    @Override
    public void execute() {
        String toCurrency = view.getToCurrency();
        String fromCurrency = view.getFromCurrency();

        double amount = Double.parseDouble(view.getAmount());
        Currency from = new Currency(getCurrencyName(fromCurrency), getCurrencyCode(fromCurrency));
        Currency to = new Currency(getCurrencyName(toCurrency), getCurrencyCode(toCurrency));

        double fromRate = Double.parseDouble(getCurrencyCode(fromCurrency));
        double toRate = Double.parseDouble(getCurrencyCode(toCurrency));

        ExchangeRate exchangeRate = new ExchangeRate(from, to, toRate / fromRate);
        Money money = new Money(amount, from);

        String result = exchange(money, exchangeRate);
        view.setResult(result);
    }

    private String exchange(Money money, ExchangeRate exchangeRate) {
        return String.valueOf(money.getAmount() * exchangeRate.getRate());
    }

    private String getCurrencyCode(String currency) {
        String[] result = (currency.split("-"));
        return result[1];
    }

    private String getCurrencyName(String currency) {
        String[] result = (currency.split("-"));
        return result[0];
    }
}
