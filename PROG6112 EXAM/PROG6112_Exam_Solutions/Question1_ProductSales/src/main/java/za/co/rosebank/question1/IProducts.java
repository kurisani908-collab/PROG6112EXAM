package za.co.rosebank.question1;

/** Defines the calculations required for the product sales report. */
public interface IProducts {
    int GetTotalProductsSold();
    double GetAverageProductSold();
    String GetMostPopularProduct();
}
