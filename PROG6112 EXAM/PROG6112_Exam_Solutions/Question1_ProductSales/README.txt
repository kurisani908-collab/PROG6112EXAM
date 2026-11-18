QUESTION 1 - PRODUCT SALES REPORT

Project type: Java Maven console application
Package: za.co.rosebank.question1
Java version: 17

NetBeans:
1. Open NetBeans.
2. Choose File > Open Project and select this Question1_ProductSales folder.
3. Allow Maven to load dependencies.
4. Run ProductSalesApp.java.
5. Enter nine whole-number values (three months for each of the three products).

Run unit tests:
- Right-click the project and choose Test, or run: mvn test

The sample values are:
Cozy Nights Monarch: 25, 18, 20 = 63
Restonic Barbados: 15, 10, 12 = 37
Sealy Phuket: 18, 15, 20 = 53
Total = 153; average across nine product-month entries = 17.

IMPORTANT:
The written instruction says most popular product is based on the highest TOTAL sales.
Therefore Cozy Nights Monarch is reported with 63. The printed sample shows 25, which is
the highest single monthly entry, not the highest three-month product total.
