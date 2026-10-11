# OCP Practice: Open/Closed Principle

## OCP Practice Question 1: Notification Service

### Problem Statement

You are building a notification system that supports multiple notification channels, including Email, SMS, and WhatsApp.

Initially, the `NotificationService` class uses `if-else` conditions to determine which notification channel to use. Whenever a new notification channel is introduced, the existing class must be modified.

Refactor the design to follow the **Open/Closed Principle (OCP)**.

### Requirements

1. Support sending notifications through Email, SMS, and WhatsApp.
2. Allow the user to select the notification channel.
3. Ensure each channel has its own notification-sending logic.
4. Allow new notification channels to be added without modifying the existing notification-processing logic.

### Tasks

1. Implement the initial design using `if-else` conditions.
2. Identify why the design violates OCP.
3. Refactor the design using Java interfaces and polymorphism.
4. Implement Email, SMS, and WhatsApp notification classes.
5. Demonstrate how a new notification channel can be added without modifying the existing service class.

### Constraints

- Use plain Java only.
- Do not use frameworks or external libraries.
- Use interfaces, classes, and polymorphism where appropriate.

### Interview Challenge

A new notification channel, such as Telegram, must be supported.

Explain which new class you would create, which existing classes would remain unchanged, and why your design follows OCP.

---
