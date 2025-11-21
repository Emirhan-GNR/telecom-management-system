# 📡 Communication System – Java Console App

This project is a simple **Java console-based communication system** that simulates mobile operators, subscribers, billing, and usage tracking. It demonstrates multi-class Object-Oriented Programming using `ServiceProvider`, `Subscriber`, `Invoice`, and `SimulateSystem`.

---

## 🚀 Features

- Create Service Providers  
- Create Subscribers  
- Make Voice Calls  
- Send Messages  
- Use Internet  
- Pay Invoice  
- Change Service Provider  
- Change Usage Limit  
- List Subscribers  
- List Service Providers  
- Fully menu-driven console UI

---

## 🧱 Project Structure

### ✔ `ServiceProvider.java`
Represents a mobile operator.

Stores:
- Provider ID  
- Name  
- Voice Call Cost  
- Messaging Cost  
- Internet Cost  
- Discount Ratio  

Provides methods to calculate:
- Voice call cost  
- Messaging cost  
- Internet cost  

---

### ✔ `Subscriber.java`
Represents a user.

Stores:
- Subscriber ID  
- Name  
- Age  
- Service Provider  
- Active Status  
- Invoice (linked object)

Subscriber actions:
- Make voice calls  
- Send messages  
- Use internet  
- Pay invoice  
- Change usage limit  
- Change service provider  

All spending is processed through the subscriber’s invoice.

---

### ✔ `Invoice.java`
Represents the billing system.

Tracks:
- Usage limit  
- Current spending  
- Last payment day  

Supports:
- Adding spending  
- Changing usage limit  
- Paying the invoice  
- Checking if the subscriber is still active  

---

### ✔ `SimulateSystem.java`
Main console menu that connects all classes.

Menu options:
1. Create Service Provider  
2. Create Subscriber  
3. Voice Call  
4. Messaging  
5. Internet Usage  
6. Pay Invoice  
7. Change Service Provider  
8. Change Usage Limit  
9. List Subscribers  
10. List Providers  
11. Exit  

Uses `Scanner` for input and `ArrayList` for storing objects.

---

## 🛠 Technologies Used

- Java (JDK 17+ recommended)  
- Scanner (user input)  
- ArrayList (object storage)  
- Random ID generation  
- OOP principles:
  - Classes  
  - Encapsulation  
  - Object interaction  

---

## ▶️ How to Run

1. Put all project files in the same folder:

Invoice.java  
ServiceProvider.java  
Subscriber.java  
SimulateSystem.java

2. Compile the project:

javac *.java

3. Run the simulation:

java SimulateSystem
