/**
 * Represents a Fine associated with a patron for overdue books or other violations.
 * Each fine has a unique ID, the patron who owes the fine, the amount of the fine, and the reason for the fine.
 */
public class Fine {
    private String id;                // Unique identifier for the fine
    private Patron patron;            // The patron who owes the fine
    private double amount;            // The amount of the fine
    private String reason;            // The reason for the fine

    /**
     * Constructor to initialize a Fine object.
     * @param id The unique identifier for the fine.
     * @param patron The patron who owes the fine.
     * @param amount The amount of the fine.
     * @param reason The reason for the fine.
     */
    public Fine(String id, Patron patron, double amount, String reason) {
        this.id = id;
        this.patron = patron;
        this.amount = amount;
        this.reason = reason;
    }

    /**
     * Retrieves the ID of the fine.
     * @return The ID of the fine.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the patron associated with the fine.
     * @return The patron associated with the fine.
     */
    public Patron getPatron() {
        return patron;
    }

    /**
     * Retrieves the amount of the fine.
     * @return The amount of the fine.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Retrieves the reason for the fine.
     * @return The reason for the fine.
     */
    public String getReason() {
        return reason;
    }

    /**
     * Processes a payment towards the fine.
     * If the payment amount is greater than or equal to the fine amount, the fine is considered paid off.
     * Otherwise, the fine amount is reduced by the payment amount.
     * @param paymentAmount The amount paid towards the fine.
     */
    public void pay(double paymentAmount) {
        if (paymentAmount >= amount) {
            patron.removeFine(this);
        } else {
            amount -= paymentAmount;
        }
    }
}
