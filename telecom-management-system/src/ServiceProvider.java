import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServiceProvider {

    private int p_id;
    private String p_name;
    private double voiceCallCost;
    private double messagingCost;
    private double internetCost;
    private int discountRatio;
    private List<Subscriber> subscribers;

    public ServiceProvider(String p_name,
                           double voiceCallCost,
                           double messagingCost,
                           double internetCost,
                           int discountRatio) {

        Random random = new Random();
        this.p_id = random.nextInt(101) + 500;
        this.p_name = p_name;
        this.voiceCallCost = voiceCallCost;
        this.messagingCost = messagingCost;
        this.internetCost = internetCost;
        this.discountRatio = discountRatio;
        this.subscribers = new ArrayList<>();
    }

    public double calculateVoiceCallCost(int minute, Subscriber caller) {
        double cost = minute * voiceCallCost;
        if (caller.getAge() < 18 || caller.getAge() >= 65) {
            cost *= (1 - discountRatio / 100.0);
        }
        return cost;
    }

    public double calculateMessagingCost(int quantity, Subscriber sender, Subscriber receiver) {
        double cost = quantity * messagingCost;

        if (sender.getAge() < 18) {
            cost *= (1 - discountRatio / 100.0);
        }

        if (quantity > 10) {
            int discountedMessages = quantity - 10;
            double discountedCost = discountedMessages * messagingCost * (1 - discountRatio / 100.0);
            cost = (10 * messagingCost) + discountedCost;
        }

        return cost;
    }

    public double calculateInternetCost(double amount, Subscriber subscriber, int hourOfDay) {
        double cost = amount * internetCost;
        boolean isNight = hourOfDay >= 0 && hourOfDay < 6;

        if (subscriber.getAge() < 18 || subscriber.getAge() >= 65 || isNight) {
            cost *= (1 - discountRatio / 100.0);
        }
        return cost;
    }

    public boolean addSubscriber(Subscriber s) {
        if (!subscribers.contains(s)) {
            subscribers.add(s);
            return true;
        }
        return false;
    }

    public boolean removeSubscriber(Subscriber s) {
        return subscribers.remove(s);
    }

    public int getPId() {
        return p_id;
    }

    public String getPName() {
        return p_name;
    }

    public double getVoiceCallCost() {
        return voiceCallCost;
    }

    public double getMessagingCost() {
        return messagingCost;
    }

    public double getInternetCost() {
        return internetCost;
    }

    public int getDiscountRatio() {
        return discountRatio;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setPName(String p_name) {
        this.p_name = p_name;
    }

    public void setVoiceCallCost(double voiceCallCost) {
        this.voiceCallCost = voiceCallCost;
    }

    public void setMessagingCost(double messagingCost) {
        this.messagingCost = messagingCost;
    }

    public void setInternetCost(double internetCost) {
        this.internetCost = internetCost;
    }

    public void setDiscountRatio(int discountRatio) {
        this.discountRatio = discountRatio;
    }
}