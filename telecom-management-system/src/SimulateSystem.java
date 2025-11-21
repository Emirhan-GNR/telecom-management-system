import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimulateSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Subscriber> subscribers = new ArrayList<>();
        List<ServiceProvider> serviceProviders = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Communication System Menu ---");
            System.out.println("1. Create a new Service Provider");
            System.out.println("2. Create a new Subscriber");
            System.out.println("3. Voice Call");
            System.out.println("4. Messaging");
            System.out.println("5. Internet Usage");
            System.out.println("6. Pay Invoice");
            System.out.println("7. Change Service Provider");
            System.out.println("8. Change Usage Limit");
            System.out.println("9. List all Subscribers");
            System.out.println("10. List all Service Providers");
            System.out.println("11. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Service Provider Name: ");
                    String p_name = scanner.nextLine();
                    System.out.print("Enter Voice Call Cost: ");
                    double voiceCallCost = scanner.nextDouble();
                    System.out.print("Enter Messaging Cost: ");
                    double messagingCost = scanner.nextDouble();
                    System.out.print("Enter Internet Cost: ");
                    double internetCost = scanner.nextDouble();
                    System.out.print("Enter Discount Ratio: ");
                    int discountRatio = scanner.nextInt();

                    ServiceProvider sp = new ServiceProvider(
                            p_name,
                            voiceCallCost,
                            messagingCost,
                            internetCost,
                            discountRatio
                    );
                    serviceProviders.add(sp);
                    System.out.println("Service Provider added! ID: " + sp.getPId());
                    break;

                case 2:
                    System.out.print("Enter Subscriber Name: ");
                    String s_name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Service Provider ID: ");
                    int sp_id = scanner.nextInt();
                    System.out.print("Enter Usage Limit: ");
                    double usageLimit = scanner.nextDouble();

                    ServiceProvider selectedProvider = null;
                    for (ServiceProvider provider : serviceProviders) {
                        if (provider.getPId() == sp_id) {
                            selectedProvider = provider;
                            break;
                        }
                    }

                    if (selectedProvider != null) {
                        Subscriber newSubscriber = new Subscriber(s_name, age, selectedProvider, usageLimit);
                        subscribers.add(newSubscriber);
                        System.out.println("Subscriber added! ID: " + newSubscriber.getSID());
                    } else {
                        System.out.println("Service Provider not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Caller ID: ");
                    int callerId = scanner.nextInt();
                    System.out.print("Enter Receiver ID: ");
                    int receiverId = scanner.nextInt();
                    System.out.print("Enter Duration (minutes): ");
                    int minutes = scanner.nextInt();

                    Subscriber caller = null;
                    Subscriber receiver = null;

                    for (Subscriber s : subscribers) {
                        if (s.getSID() == callerId) {
                            caller = s;
                        }
                        if (s.getSID() == receiverId) {
                            receiver = s;
                        }
                    }

                    if (caller != null && receiver != null) {
                        caller.makeVoiceCall(minutes, receiver);
                    } else {
                        System.out.println("Subscriber not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Sender ID: ");
                    int senderId = scanner.nextInt();
                    System.out.print("Enter Receiver ID: ");
                    int msgReceiverId = scanner.nextInt();
                    System.out.print("Enter Message Quantity: ");
                    int quantity = scanner.nextInt();

                    Subscriber sender = null;
                    Subscriber msgReceiver = null;

                    for (Subscriber s : subscribers) {
                        if (s.getSID() == senderId) {
                            sender = s;
                        }
                        if (s.getSID() == msgReceiverId) {
                            msgReceiver = s;
                        }
                    }

                    if (sender != null && msgReceiver != null) {
                        sender.sendMessage(quantity, msgReceiver);
                    } else {
                        System.out.println("Subscriber not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Subscriber ID: ");
                    int internetId = scanner.nextInt();
                    System.out.print("Enter Data Amount (MB): ");
                    double dataAmount = scanner.nextDouble();

                    Subscriber internetUser = null;
                    for (Subscriber s : subscribers) {
                        if (s.getSID() == internetId) {
                            internetUser = s;
                        }
                    }

                    if (internetUser != null) {
                        internetUser.connectToInternet(dataAmount);
                    } else {
                        System.out.println("Subscriber not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Subscriber ID: ");
                    int payId = scanner.nextInt();
                    System.out.print("Enter amount to pay: ");
                    double amount = scanner.nextDouble();

                    for (Subscriber s : subscribers) {
                        if (s.getSID() == payId) {
                            s.getInvoice().pay(amount);
                            System.out.println("Payment successful.");
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter Subscriber ID: ");
                    int changeId = scanner.nextInt();
                    System.out.print("Enter New Service Provider ID: ");
                    int newProviderId = scanner.nextInt();

                    Subscriber changing = null;
                    ServiceProvider newSP = null;

                    for (Subscriber s : subscribers) {
                        if (s.getSID() == changeId) {
                            changing = s;
                        }
                    }
                    for (ServiceProvider s : serviceProviders) {
                        if (s.getPId() == newProviderId) {
                            newSP = s;
                        }
                    }

                    if (changing != null && newSP != null) {
                        changing.changeServiceProvider(newSP);
                    } else {
                        System.out.println("Invalid subscriber or provider.");
                    }
                    break;

                case 8:
                    System.out.print("Enter Subscriber ID: ");
                    int limitId = scanner.nextInt();
                    System.out.print("Enter New Limit: ");
                    double newLimit = scanner.nextDouble();

                    for (Subscriber s : subscribers) {
                        if (s.getSID() == limitId) {
                            s.getInvoice().changeUsageLimit(newLimit);
                            System.out.println("Limit changed.");
                        }
                    }
                    break;

                case 9:
                    if (subscribers.isEmpty()) {
                        System.out.println("No subscribers found.");
                    } else {
                        for (Subscriber s : subscribers) {
                            System.out.println(
                                    "ID: " + s.getSID() +
                                    " | Name: " + s.getName() +
                                    " | Active: " + s.isActive() +
                                    " | Provider: " + s.getServiceProvider().getPName() +
                                    " | Spending: " + s.getInvoice().getCurrentSpending()
                            );
                        }
                    }
                    break;

                case 10:
                    if (serviceProviders.isEmpty()) {
                        System.out.println("No service providers found.");
                    } else {
                        for (ServiceProvider s : serviceProviders) {
                            System.out.println(
                                    "ID: " + s.getPId() +
                                    " | Name: " + s.getPName() +
                                    " | Voice: " + s.getVoiceCallCost() +
                                    " | Msg: " + s.getMessagingCost() +
                                    " | Net: " + s.getInternetCost() +
                                    " | Discount: " + s.getDiscountRatio()
                            );
                        }
                    }
                    break;

                case 11:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}