package za.co.rosebank.question1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product sampleProduct() {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        return new Product(names, sales);
    }

    @Test
    void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, sampleProduct().GetTotalProductsSold());
    }

    @Test
    void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, sampleProduct().GetAverageProductSold(), 0.0001);
    }

    @Test
    void GetMostPopularProduct_WithValidData_ReturnsHighestProductTotal() {
        assertEquals("Cozy Nights Monarch (63)", sampleProduct().GetMostPopularProduct());
    }
}
