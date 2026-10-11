
## OCP Practice Question 2: Payment Processing System

### Problem Statement

You are building a payment-processing system that supports UPI, Credit Card, and PayPal payments.

The `PaymentProcessor` class uses a `switch` statement to select the appropriate payment method. Whenever a new payment method is introduced, the existing processing logic must be modified.

Refactor the design to follow the **Open/Closed Principle (OCP)**.

### Requirements

1. Support UPI, Credit Card, and PayPal payments.
2. Each payment method must implement its own payment-processing logic.
3. Allow the payment processor to process a payment using the selected method.
4. Allow new payment methods to be introduced without modifying the existing payment-processing logic.

### Tasks

1. Implement the initial design using a `switch` statement.
2. Identify why the design violates OCP.
3. Define a common interface for payment methods.
4. Implement separate classes for UPI, Credit Card, and PayPal payments.
5. Refactor `PaymentProcessor` to work with the common interface.
6. Demonstrate how a new payment method can be added without modifying the existing processor.

### Constraints

- Use plain Java only.
- Do not use frameworks or external libraries.
- Use interfaces and polymorphism.
- Simulate payment processing with console output; actual payment gateway integration is not required.

### Interview Challenge

The system must now support Net Banking and cryptocurrency payments.

Explain how your design accommodates these additions and whether the existing `PaymentProcessor` class needs to change.

---

## Learning Objectives

After completing both exercises, you should be able to:

- Explain the Open/Closed Principle in practical terms.
- Identify designs that require repeated modifications when requirements change.
- Use interfaces and polymorphism to support extensibility.
- Distinguish between adding a new implementation and modifying existing business logic.
- Explain your design decisions clearly in a technical interview.

---