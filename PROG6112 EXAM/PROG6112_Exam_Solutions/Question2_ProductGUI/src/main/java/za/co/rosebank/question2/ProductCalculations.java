package za.co.rosebank.question2;

/** Calculates VAT, commission and the final sale amount from a product price. */
public class ProductCalculations implements IProductCalculations {
    private final double productPrice;

    public ProductCalculations(double productPrice) {
        if (!Double.isFinite(productPrice) || productPrice < 0) {
            throw new IllegalArgumentException("Product price must be a valid non-negative amount.");
        }
        this.productPrice = productPrice;
    }

    @Override
    public double GetVat() {
        return productPrice * 0.15;
    }

    @Override
    public double GetCommission() {
        return productPrice * 0.05;
    }

    @Override
    public double GetTotal() {
        return productPrice + GetVat() + GetCommission();
    }
}
