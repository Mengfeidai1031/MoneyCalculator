package software.ulpgc.moneycalculator.architecture.view;

import software.ulpgc.moneycalculator.architecture.model.Currency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

public class CalculatorDisplay extends JPanel implements Display {
    private final JButton calculateButton = new JButton("Exchange");
    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;
    private JTextField amount;
    private JLabel resultLabel;
    private JLabel infoLabel;

    public void display(List<Currency> currencies) {
        setLayout(new BorderLayout());
        setBackground(Color.CYAN);

        JLabel titleLabel = new JLabel("Money Calculator", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        titleLabel.setForeground(Color.BLACK);
        add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.add(displayComponents(currencies));
        add(centerPanel, BorderLayout.CENTER);

        JLabel nameLabel = new JLabel("Meng Fei Dai - (meng.dai101@alu.ulpgc.es)", JLabel.LEFT);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(nameLabel, BorderLayout.SOUTH);
    }

    private JPanel displayComponents(List<Currency> currencies) {
        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        infoLabel = new JLabel("Info: Select currencies to see details.");
        infoLabel.setFont(new Font("Arial", Font.ITALIC, 14));

        amount = new JTextField(6);
        fromCurrency = createSelector(currencies);
        toCurrency = createSelector(currencies);

        JPanel topRowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topRowPanel.setOpaque(false);
        topRowPanel.add(new JLabel("Amount:"));
        topRowPanel.add(amount);
        topRowPanel.add(new JLabel("From Currency:"));
        topRowPanel.add(fromCurrency);
        topRowPanel.add(new JLabel("To Currency:"));
        topRowPanel.add(toCurrency);
        topRowPanel.add(calculateButton);
        topRowPanel.add(Box.createHorizontalStrut(100));
        topRowPanel.add(resultLabel);
        topRowPanel.add(infoLabel);
        topRowPanel.add(Box.createHorizontalStrut(250));
        topRowPanel.add(createImagePanel());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setOpaque(false);
        mainPanel.add(topRowPanel);

        return mainPanel;
    }

    private JComboBox<Currency> createSelector(List<Currency> currencies) {
        JComboBox<Currency> selector = new JComboBox<>();
        for (Currency currency : currencies) selector.addItem(currency);
        return selector;
    }

    private JLabel createImagePanel() {
        try {
            URL imageUrl = new URL("https://www.ulpgc.es/sites/default/files/ArchivosULPGC/identidad-corporativa/Logo%2025%20Aniversario/logo_ulpgc_version_horizontal_alternativa_positiva_azul.png");
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage().getScaledInstance(500, 250, Image.SCALE_SMOOTH); // Ajustar tamaño
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            return imageLabel;
        } catch (Exception e) {
            JLabel errorLabel = new JLabel("Error loading image");
            errorLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            return errorLabel;
        }
    }

    public void exchange(ActionListener listener) {
        calculateButton.addActionListener(listener);
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getFromCurrency() {
        return fromCurrency.getSelectedItem().toString();
    }

    public String getToCurrency() {
        return toCurrency.getSelectedItem().toString();
    }

    public void setResult(String result) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            double numericResult = Double.parseDouble(result);
            resultLabel.setText("Result: " + decimalFormat.format(numericResult));
            updateCurrencyInfo();
        } catch (NumberFormatException e) {
            resultLabel.setText("Result: " + result);
        }
    }

    private void updateCurrencyInfo() {
        String from = fromCurrency.getSelectedItem().toString();
        String to = toCurrency.getSelectedItem().toString();
        infoLabel.setText("<html><strong>From:</strong> " + from +
                "<br><strong>To:</strong> " + to + "</html>");
    }
}

