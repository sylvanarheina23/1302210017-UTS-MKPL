public class TaxFunction {
    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthsWorked, int deductible, boolean isMarried, int numberOfChildren) {
        if (numberOfMonthsWorked > 12) {
            throw new IllegalArgumentException("Number of months worked cannot exceed 12.");
        }

        if (numberOfChildren > 3) {
            numberOfChildren = 3;
        }

        int nonTaxableIncome = calculateNonTaxableIncome(isMarried, numberOfChildren);

        int taxableIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthsWorked - deductible - nonTaxableIncome;
        int tax = (int) Math.round(0.05 * taxableIncome);

        return Math.max(tax, 0); // Ensure tax is non-negative
    }

    private static int calculateNonTaxableIncome(boolean isMarried, int numberOfChildren) {
        int nonTaxableIncome = 54000000;
        if (isMarried) {
            nonTaxableIncome += 4500000;
        }
        nonTaxableIncome += numberOfChildren * 1500000;
        return nonTaxableIncome;
    }
}
