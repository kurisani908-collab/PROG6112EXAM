package za.co.rosebank.question2;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;

/** Swing application for capturing mattress sales and saving a data log. */
public class ProductApp extends JFrame {
    private final JTextField customerNameField = new JTextField(20);
    private final JComboBox<String> productComboBox = new JComboBox<>(new String[] {
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
    });
    private final JTextField priceField = new JTextField(20);
    private final DecimalFormat currencyFormat = new DecimalFormat("0.00");

    public ProductApp() {
        setTitle("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMenuBar());
        buildForm();
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void buildForm() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(9, 8, 9, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addFormRow(formPanel, gbc, 0, "Customer Name:", customerNameField);
        addFormRow(formPanel, gbc, 1, "Select Product:", productComboBox);
        addFormRow(formPanel, gbc, 2, "Enter Price:", priceField);

        JButton processButton = new JButton("PROCESS");
        processButton.addActionListener(event -> processSale());
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 1;
        formPanel.add(processButton, gbc);

        setContentPane(formPanel);
    }

    private void addFormRow(JPanel panel, GridBagConstraints gbc, int row,
                            String label, Component field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.weightx = 0;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(field, gbc);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(event -> dispose());
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        processItem.addActionListener(event -> processSale());
        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(event -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        return menuBar;
    }

    /** Validates the form, calculates the sale and appends a record to data.txt. */
    private void processSale() {
        String customerName = customerNameField.getText().trim();
        String productName = (String) productComboBox.getSelectedItem();
        String priceText = priceField.getText().trim();

        if (customerName.isEmpty()) {
            showError("Please enter the customer's name.");
            customerNameField.requestFocus();
            return;
        }
        if (priceText.isEmpty()) {
            showError("Please enter the product price.");
            priceField.requestFocus();
            return;
        }

        final double price;
        try {
            price = Double.parseDouble(priceText);
            if (!Double.isFinite(price) || price <= 0) {
                showError("Price must be a number greater than zero.");
                priceField.requestFocus();
                return;
            }
        } catch (NumberFormatException exception) {
            showError("Invalid price. Enter a valid number, for example 3500.");
            priceField.requestFocus();
            return;
        }

        ProductCalculations calculations = new ProductCalculations(price);
        String vat = currencyFormat.format(calculations.GetVat());
        String commission = currencyFormat.format(calculations.GetCommission());
        String total = currencyFormat.format(calculations.GetTotal());

        String record = "DATA LOG\n"
                + "****************************************\n"
                + "Customer Name: " + customerName + "\n"
                + "Product: " + productName + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total + "\n"
                + "****************************************\n\n";

        try {
            saveRecord(record);
            JOptionPane.showMessageDialog(this,
                    "Customer Name: " + customerName
                    + "\nProduct: " + productName
                    + "\nVAT: R " + vat
                    + "\nCOMMISSION: R " + commission
                    + "\nTOTAL: R " + total,
                    "Sale processed", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this,
                    "The sale was calculated, but data.txt could not be saved.\n"
                    + exception.getMessage(),
                    "File error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveRecord(String record) throws IOException {
        Path file = Path.of("data.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(file,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            writer.write(record);
        }
    }

    private void clearForm() {
        customerNameField.setText("");
        priceField.setText("");
        productComboBox.setSelectedIndex(0);
        customerNameField.requestFocus();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Input error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}
