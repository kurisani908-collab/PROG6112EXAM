package za.co.rosebank.question1;

/** Stores monthly sales and calculates report statistics for three products. */
public class Product implements IProducts {
    private final String[] productNames;
    private final int[][] monthlySales;

    /**
     * @param productNames names corresponding to each row in monthlySales
     * @param monthlySales three monthly sales values for each product
     */
    public Product(String[] productNames, int[][] monthlySales) {
        if (productNames == null || monthlySales == null ||
            productNames.length == 0 || productNames.length != monthlySales.length) {
            throw new IllegalArgumentException("Product names and sales rows must match.");
        }
        this.productNames = productNames.clone();
        this.monthlySales = new int[monthlySales.length][];
        for (int row = 0; row < monthlySales.length; row++) {
            if (monthlySales[row] == null || monthlySales[row].length != 3) {
                throw new IllegalArgumentException("Each product must have exactly three monthly values.");
            }
            this.monthlySales[row] = monthlySales[row].clone();
            for (int value : this.monthlySales[row]) {
                if (value < 0) throw new IllegalArgumentException("Sales cannot be negative.");
            }
        }
    }

    /** Returns the sum of all products sold across all three months. */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] productSales : monthlySales) {
            for (int monthlySale : productSales) total += monthlySale;
        }
        return total;
    }

    /** Returns the average per product-month entry (three products x three months). */
    @Override
    public double GetAverageProductSold() {
        int numberOfEntries = 0;
        for (int[] productSales : monthlySales) numberOfEntries += productSales.length;
        return numberOfEntries == 0 ? 0.0 : (double) GetTotalProductsSold() / numberOfEntries;
    }

    /** Returns the product with the greatest combined sales across the three months. */
    @Override
    public String GetMostPopularProduct() {
        int highestTotal = Integer.MIN_VALUE;
        int highestIndex = 0;
        for (int row = 0; row < monthlySales.length; row++) {
            int productTotal = 0;
            for (int monthlySale : monthlySales[row]) productTotal += monthlySale;
            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                highestIndex = row;
            }
        }
        return productNames[highestIndex] + " (" + highestTotal + ")";
    }

    /** Returns a defensive copy for report printing. */
    public int[][] getMonthlySales() {
        int[][] copy = new int[monthlySales.length][];
        for (int i = 0; i < monthlySales.length; i++) copy[i] = monthlySales[i].clone();
        return copy;
    }

    public String[] getProductNames() {
        return productNames.clone();
    }

    public int getProductTotal(int productIndex) {
        int total = 0;
        for (int sale : monthlySales[productIndex]) total += sale;
        return total;
    }
}
