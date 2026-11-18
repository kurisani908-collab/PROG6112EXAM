QUESTION 2 - PRODUCT SALES GUI

Project type: Java Maven Swing GUI application
Package: za.co.rosebank.question2
Java version: 17

NetBeans:
1. Open NetBeans.
2. Choose File > Open Project and select this Question2_ProductGUI folder.
3. Allow Maven to load dependencies.
4. Run ProductApp.java.
5. Enter a customer name, select a mattress, enter a price and click PROCESS.

Required example:
Customer: Joe Bloggs
Product: Cozy Nights Monarch
Price: R3500
VAT (15%): R525.00
Commission (5%): R175.00
Total: R4200.00

The application includes:
- Customer name text field
- Product combo box with the three specified products
- Price text field
- Process button
- File > Exit menu
- Tools > Process and Tools > Clear menu items
- Input validation
- data.txt append-only sales log
- IProductCalculations interface and ProductCalculations implementation
- JUnit tests

Run unit tests:
- Right-click the project and choose Test, or run: mvn test

File location:
data.txt is created in the application's working directory when the first sale is processed.
Each sale is appended so earlier records are preserved.
