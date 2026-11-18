package za.co.rosebank.question2;

/** Contract for the three sales calculations. */
public interface IProductCalculations {
    double GetVat();
    double GetCommission();
    double GetTotal();
}
