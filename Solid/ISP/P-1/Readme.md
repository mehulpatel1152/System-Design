# ISP Advanced Practice: Multi-Channel Notification Platform

## Problem Statement

A company has a notification system built around a single `NotificationProvider` interface. The interface exposes five operations:

```java
interface NotificationProvider {
    void send(String message);
    void schedule(String message, long timestamp);
    void cancel(String notificationId);
    void trackDelivery(String notificationId);
    void getDeliveryReport(String notificationId);
}
```

The system supports four notification providers:

- **EmailProvider:** Supports sending, scheduling, cancellation, and delivery reports.
- **SMSProvider:** Supports sending and delivery tracking, but cancellation is unavailable after submission.
- **WhatsAppProvider:** Supports sending and delivery reports, but does not support scheduling.
- **PushNotificationProvider:** Supports sending and cancellation, but delivery reports are unavailable on some devices.

The current design violates the Interface Segregation Principle (ISP) because every provider is forced to implement operations it cannot meaningfully support. This can lead to empty methods, misleading behavior, and unsupported-operation exceptions.

## Objective

Refactor the notification platform using the **Interface Segregation Principle (ISP)** while maintaining extensibility and avoiding unnecessary dependencies between clients and provider capabilities.

## Requirements

1. Split the monolithic interface into cohesive, capability-based interfaces.
2. Ensure each provider implements only the capabilities it genuinely supports.
3. Design `NotificationService` to send notifications through any supported provider.
4. Support scheduling, cancellation, delivery tracking, and delivery reports where available.
5. Avoid excessive `instanceof` checks, downcasting, and provider-specific conditional logic.
6. Allow new notification providers to be added without modifying existing provider implementations.
7. Do not create a separate interface for every concrete provider. Design interfaces around capabilities and client requirements.
8. Handle unavailable capabilities explicitly without pretending that unsupported operations succeeded.

## Tasks

1. Identify the ISP violations in the existing design.
2. Define the appropriate capability interfaces.
3. Implement `EmailProvider`, `SMSProvider`, `WhatsAppProvider`, and `PushNotificationProvider`.
4. Refactor `NotificationService` to depend on appropriate abstractions.
5. Design a mechanism to access optional capabilities without repeatedly inspecting concrete provider types.
6. Add a new notification provider without modifying existing provider implementations or core service logic.
7. Demonstrate sending notifications and using supported optional capabilities.
8. Explain the design decisions and justify how they satisfy ISP and OCP.

## Constraints

- Use plain Java only.
- Do not use frameworks, databases, or external libraries.
- Do not use `UnsupportedOperationException` merely because a provider is forced to implement an unsupported operation.
- Avoid excessive type checks and downcasting.
- Do not solve the problem by creating one interface per concrete provider.

## Expected Deliverables

- Capability-based interface design.
- Implementations for all four notification providers.
- A refactored `NotificationService`.
- A small `Main` class demonstrating the supported operations.
- A short explanation of how the design follows ISP and supports extensibility.

## Interview Challenges

### Challenge 1: Optional Capabilities

If `NotificationService` receives a provider through a reference to a general notification interface, how can it access scheduling or cancellation without downcasting?

### Challenge 2: Provider Limitations

Push notifications do not always provide delivery reports. How should the design represent this limitation without reporting false success or forcing every push provider to implement an unsupported operation?

### Challenge 3: Extensibility

Introduce a new provider that supports sending and delivery tracking but not scheduling or cancellation. Which existing classes should remain unchanged, and why?

### Challenge 4: Interface Design

Would creating separate interfaces for sending, scheduling, cancellation, tracking, and reporting always be the best design? Explain how you would group capabilities based on actual client requirements.

## Completion Checklist

- [ ] ISP violations identified.
- [ ] Cohesive capability interfaces designed.
- [ ] Each provider implements only supported capabilities.
- [ ] `NotificationService` sends through any supported provider.
- [ ] Optional operations work without excessive type checks or downcasting.
- [ ] Unsupported capabilities are represented explicitly.
- [ ] A new provider can be added without modifying existing provider implementations.
- [ ] The implementation demonstrates the design using plain Java.
- [ ] ISP and OCP design decisions can be explained in an interview.