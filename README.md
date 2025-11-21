# 📡 Telecom Management System – Java OOP Console Project

The **Telecom Management System** is a Java console application designed to simulate basic telecommunication operations such as voice calls, messaging, data usage, billing, and service provider management.  
The project demonstrates clean **Object-Oriented Programming** structure, method-based logic, and the interaction between multiple domain classes.

---

## 📌 Overview

The system manages three core entities:

- **Subscriber** → makes calls, sends messages, uses internet  
- **ServiceProvider** → defines pricing and discounts  
- **Invoice** → tracks spending, usage limits, and payments  

A console-based menu allows users to:

- Create service providers  
- Create subscribers  
- Make voice calls  
- Send messages  
- Use internet  
- Pay invoices  
- Change service providers  
- Update usage limits  
- List all subscribers and service providers  

All operations are done in memory using Java collections.

---

## 🧱 OOP Concepts Used

### 🔹 Classes & Encapsulation  
Each entity (`Subscriber`, `ServiceProvider`, `Invoice`) holds its own data and behavior with private fields + public methods.

### 🔹 Interaction Between Objects  
Subscribers interact with service providers for pricing, and all usage is logged into the associated invoice.

### 🔹 Method-Based Design  
Operations such as `makeVoiceCall()`, `sendMessage()`, `useInternet()`, `payBill()`, and cost calculations are implemented through modular, reusable methods.

### 🔹 Polymorphism (via design structure)  
Even though not heavily subclass-driven, the system uses clean separation of responsibilities and cross-class communication.

### 🔹 Error & Limit Handling  
Methods such as `isLimitExceeded()` and usage of validation logic help keep operations safe and controlled.
