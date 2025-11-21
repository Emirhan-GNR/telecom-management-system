import java.util.Calendar;
import java.util.Random;

public class Subscriber {

    private int s_id;
    private String name;
    private int age;
    private boolean isActive;
    private ServiceProvider s_provider;
    private Invoice invoice;

    public Subscriber(String name, int age, ServiceProvider s_provider, double usageLimit) {
        Random random = new Random();
        this.s_id = random.nextInt(8_000_001) + 1_000_000;
        this.name = name;
        this.age = age;
        this.isActive = true;
        this.s_provider = s_provider;
        this.invoice = new Invoice(usageLimit);
        s_provider.addSubscriber(this);
    }

    public int getSID() {
        return s_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }

    public ServiceProvider getServiceProvider() {
        return s_provider;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServiceProvider(ServiceProvider s_provider) {
        this.s_provider = s_provider;
    }

    private void updateStatus() {
        if (Calendar.getInstance().getTime().after(invoice.getLastDayToPay())) {
            isActive = false;
        }
    }

    public void makeVoiceCall(int minutes, Subscriber receiver) {
        updateStatus();
        if (!isActive) {
            System.out.println("Cannot make a call. Subscriber is inactive.");
            return;
        }

        double cost = s_provider.calculateVoiceCallCost(minutes, this);
        if (invoice.isLimitExceeded(cost)) {
            System.out.println("Call failed. Usage limit exceeded.");
            return;
        }

        invoice.addCost(cost);
        System.out.println(name + " made a voice call to " + receiver.getName() +
                           " for " + minutes + " minutes.");
    }

    public void sendMessage(int quantity, Subscriber receiver) {
        updateStatus();
        if (!isActive) {
            System.out.println("Cannot send a message. Subscriber is inactive.");
            return;
        }

        double cost = s_provider.calculateMessagingCost(quantity, this, receiver);
        if (invoice.isLimitExceeded(cost)) {
            System.out.println("Message failed. Usage limit exceeded.");
            return;
        }

        invoice.addCost(cost);
        System.out.println(name + " sent " + quantity + " message(s) to " + receiver.getName() + ".");
    }

    public void useInternet(double amount, int hourOfDay) {
        updateStatus();
        if (!isActive) {
            System.out.println("Cannot connect to the internet. Subscriber is inactive.");
            return;
        }

        double cost = s_provider.calculateInternetCost(amount, this, hourOfDay);
        if (invoice.isLimitExceeded(cost)) {
            System.out.println("Connection failed. Usage limit exceeded.");
            return;
        }

        invoice.addCost(cost);
        System.out.println(name + " used " + amount + "MB of data.");
    }

    public void payBill(double amount) {
        invoice.payBill(amount);
        if (invoice.getCurrentSpending() <= 0) {
            isActive = true;
        }
    }

    public void changeUsageLimit(double amount) {
        invoice.changeUsageLimit(amount);
    }

    public void changeServiceProvider(ServiceProvider newProvider) {
        updateStatus();
        if (invoice.getCurrentSpending() > 0) {
            System.out.println("Cannot change provider. Unpaid invoice exists.");
            return;
        }
        s_provider.removeSubscriber(this);
        this.s_provider = newProvider;
        newProvider.addSubscriber(this);
        System.out.println(name + " changed service provider to " + newProvider.getPName());
    }
}