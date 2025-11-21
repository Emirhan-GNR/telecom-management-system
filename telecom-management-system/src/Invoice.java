public class Invoice {

    private String invoiceNo;
    private String subscriberName;
    private String providerName;
    private double cost;
    private double discountRatio;

    public Invoice(String invoiceNo, String subscriberName, String providerName, double cost, double discountRatio) {
        this.invoiceNo = invoiceNo;
        this.subscriberName = subscriberName;
        this.providerName = providerName;
        this.cost = cost;
        this.discountRatio = discountRatio;
    }

    public double calculateFinalCost() {
        double finalCost = cost;
        if (discountRatio > 0) {
            finalCost *= (1 - discountRatio / 100.0);
        }
        return finalCost;
    }

    public void printInvoice() {
        System.out.println("------ Invoice ------");
        System.out.println("Invoice No: " + invoiceNo);
        System.out.println("Subscriber: " + subscriberName);
        System.out.println("Provider: " + providerName);
        System.out.println("Initial Cost: " + cost + " TL");
        System.out.println("Discount: " + discountRatio + "%");
        System.out.println("Final Cost: " + calculateFinalCost() + " TL");
        System.out.println("---------------------\n");
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public String getProviderName() {
        return providerName;
    }

    public double getCost() {
        return cost;
    }

    public double getDiscountRatio() {
        return discountRatio;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setDiscountRatio(double discountRatio) {
        this.discountRatio = discountRatio;
    }
}