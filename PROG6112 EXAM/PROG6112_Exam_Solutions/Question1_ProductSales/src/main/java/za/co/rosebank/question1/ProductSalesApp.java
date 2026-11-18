package za.co.rosebank.question1;

import java.util.Scanner;

/** Console entry point for the three-product, three-month sales report. */
public class ProductSalesApp {
    private static final String[] PRODUCT_NAMES = {
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"
    };
    private static final String[] MONTHS = {"month 1", "month 2", "month 3"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] sales = new int[PRODUCT_NAMES.length][MONTHS.length];

        // Read each monthly sales value and reject negative or non-numeric input.
        for (int product = 0; product < PRODUCT_NAMES.length; product++) {
            for (int month = 0; month < MONTHS.length; month++) {
                sales[product][month] = readNonNegativeInteger(
                    scanner, "Enter number of sales for " + MONTHS[month] + " for "
                    + PRODUCT_NAMES[product] + " mattress: ");
            }
            System.out.println();
        }

        Product productReport = new Product(PRODUCT_NAMES, sales);
        new PrintProduct().PrintReport(productReport);
    }

    private static int readNonNegativeInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= 0) return value;
                System.out.println("Please enter zero or a positive whole number.");
            } else {
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Discard invalid token to prevent an endless loop.
            }
        }
    }
}
