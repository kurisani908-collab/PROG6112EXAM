package za.co.rosebank.question1;

/** Responsible only for displaying the sales report. */
public class PrintProduct {
    private static final String LINE = "********************************************";

    public void PrintTotalProductSales(Product product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void PrintAverageProductSales(Product product) {
        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n", product.GetAverageProductSold());
    }

    public void PrintMostPopularProduct(Product product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    /** Prints a table containing each product's three monthly values and combined total. */
    public void PrintReport(Product product) {
        String[] names = product.getProductNames();
        int[][] sales = product.getMonthlySales();

        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println(LINE);
        System.out.printf("%-27s %8s %8s %8s %9s%n", "PRODUCT", "MONTH 1", "MONTH 2", "MONTH 3", "TOTAL");
        System.out.println(LINE);
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-27s %8d %8d %8d %9d%n",
                    names[i], sales[i][0], sales[i][1], sales[i][2], product.getProductTotal(i));
        }
        System.out.println(LINE);
        PrintTotalProductSales(product);
        PrintAverageProductSales(product);
        PrintMostPopularProduct(product);
        System.out.println(LINE);
    }
}
