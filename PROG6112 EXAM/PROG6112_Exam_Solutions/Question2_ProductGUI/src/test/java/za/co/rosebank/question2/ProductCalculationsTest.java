package za.co.rosebank.question2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductCalculationsTest {
    @Test
    void GetVat_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calculations = new ProductCalculations(3500.00);
        assertEquals(525.00, calculations.GetVat(), 0.001);
    }

    @Test
    void GetCommission_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calculations = new ProductCalculations(3500.00);
        assertEquals(175.00, calculations.GetCommission(), 0.001);
    }

    @Test
    void GetTotal_WithValidData_ReturnsCorrectValue() {
        ProductCalculations calculations = new ProductCalculations(3500.00);
        assertEquals(4200.00, calculations.GetTotal(), 0.001);
    }

    @Test
    void Constructor_WithNegativePrice_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new ProductCalculations(-1));
    }
}
