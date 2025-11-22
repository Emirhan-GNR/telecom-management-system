# 📡 Telecom Management System – Java Console Simulation

This repository contains a **Java console-based telecommunication simulation system** built around core OOP principles.  
The project models how a telecom operator manages subscribers, tracks their usage, and generates invoices in real time.

It focuses on **clean object relationships**, **usage validation**, and **simple but realistic billing logic**, all implemented using pure Java (no external libraries).

---

## 🧱 System Overview

The simulation includes three main entities:

- **ServiceProvider** → The telecom operator  
- **Subscriber** → A customer who uses telecom services  
- **Invoice** → Tracks spending, limits, and payments  

Each subscriber is associated with a specific provider, and every call/message/internet usage dynamically updates the user’s invoice.

The system runs through a menu-driven console interface where the user can create providers, register subscribers, perform actions, and inspect invoices.

---

## 👤 Subscriber Features

Each subscriber has:

- Auto-generated **subscriber ID**
- Full name & age
- A usage limit (monthly budget)
- A linked service provider
- An associated **Invoice** object
- Active/inactive status

Subscribers can:

- 📞 **Make voice calls**  
- 💬 **Send messages**  
- 🌐 **Use internet data**  
- 🧾 **View their invoice**  
- ✖️ **Deactivate or activate their account**

Every action immediately affects their invoice total.

---

## 🏢 Service Provider Features

A service provider defines the pricing model:

- Cost per **voice minute**
- Cost per **message**
- Cost per **MB of internet**
- A **discount ratio**
- A dynamic list of subscribers

Providers can:

- Register subscribers  
- Apply discounts  
- Display subscriber details  
- Show provider information  

Each provider maintains its own separate subscriber base.

---

## 🧾 Invoice Logic

The invoice is the financial engine of the system.

It tracks:

- Monthly **usage limit**
- Current **spending**
- Last **payment date**  
- Remaining balance  
- Whether the limit is exceeded  

Every time a subscriber uses a service:

- The system checks if spending will exceed the limit  
- If allowed:
  - Usage cost is calculated based on provider prices  
  - Discounts (if any) are applied  
  - Total spending increases  
- If not allowed:
  - The action is **blocked**  
  - A message warns the user about the limit  

The invoice also generates a realistic payment deadline: `currentDate + 7 days`.

---

## 🖥️ Console Simulation (SimulateSystem)

The entire system runs through a menu such as:

1. Create Service Provider  
2. Create Subscriber  
3. Show Providers  
4. Show Subscribers  
5. Make a Voice Call  
6. Send a Message  
7. Use Internet  
8. Display Subscriber Invoice  
9. Exit System  

Internally, the system uses:

- `ArrayList<ServiceProvider>` to store providers  
- `ArrayList<Subscriber>` for all subscribers  
- Object references (`Subscriber → Invoice`, `Subscriber → ServiceProvider`)  
- Input validation for wrong actions (e.g., inactive subscriber, insufficient limit, invalid IDs)

---

## 🧩 Technical Highlights

This project demonstrates several key programming concepts:

- **Object-Oriented Design**
  - Encapsulation
  - Composition
  - Interacting objects (Subscriber–Provider–Invoice)
- **Validation Methods**
  - Age checks
  - Spending limit checks
  - Active/inactive status management
- **Random ID generation**
- **Menu-driven execution using Scanner**
- **Real-time invoice updates**
- **Use of ArrayList for dynamic storage**

These make the project a clean example of practical OOP simulation.

---
