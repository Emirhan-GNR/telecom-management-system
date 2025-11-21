package src;

import java.util.Calendar;
import java.util.Date;

public class Invoice {

    private double usageLimit;
    private double currentSpending;
    private Date lastDayToPay;

    public Invoice(double usageLimit) {
        if (usageLimit < 0) throw new IllegalArgumentException("usageLimit cannot be negative");
        this.usageLimit = usageLimit;
        this.currentSpending = 0;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        this.lastDayToPay = cal.getTime();
    }

    public boolean isLimitExceeded(double additionalCost) {
        if (additionalCost < 0) throw new IllegalArgumentException("additionalCost cannot be negative");
        return currentSpending + additionalCost > usageLimit;
    }

    public void addCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("cost cannot be negative");
        currentSpending += cost;
    }

    public void payBill(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount cannot be negative");
        currentSpending -= amount;
        if (currentSpending < 0) currentSpending = 0;
    }

    public void changeUsageLimit(double newLimit) {
        if (newLimit < 0) throw new IllegalArgumentException("newLimit cannot be negative");
        usageLimit = newLimit;
    }

    public double getCurrentSpending() {
        return currentSpending;
    }

    public double getUsageLimit() {
        return usageLimit;
    }

    public Date getLastDayToPay() {
        return lastDayToPay;
    }
}