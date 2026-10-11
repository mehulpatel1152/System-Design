# LSP Practice: E-Commerce Order Fulfillment System

## Problem Statement

A company has an order-processing system with the following Java design:

- `OrderProcessor` accepts any `PaymentMethod` and calls `pay()`.
- `PaymentMethod` is the parent class for `CreditCardPayment`, `UPIPayment`, and `CashOnDelivery`.
- `CashOnDelivery` throws `UnsupportedOperationException` when `pay()` is called because payment happens at delivery.
- `RefundablePayment` extends `PaymentMethod` and provides a `refund()` method, but some payment providers do not support refunds.
- The order-processing system assumes every payment method supports immediate payment and can be refunded after a successful payment.

Refactor the design to follow the **Liskov Substitution Principle (LSP)** without breaking existing order-processing behaviour.

## Requirements

1. Support immediate payments through credit cards, UPI, and other payment providers.
2. Support Cash on Delivery without pretending that payment happens immediately.
3. Support refunds only for eligible payment methods.
4. Allow new payment providers to be added without modifying existing order-processing logic.
5. Avoid excessive type checks, `instanceof`, and downcasting.
6. Ensure payment and refund operations respect their defined behavioural contracts.

## Tasks

1. Analyse the existing design and identify its LSP violations.
2. Identify the behavioural contracts that each payment type must satisfy.
3. Design appropriate interfaces and abstractions around payment capabilities.
4. Implement separate classes for credit card payments, UPI payments, and Cash on Delivery.
5. Design refund support so that only eligible payment methods expose the refund operation.
6. Refactor `OrderProcessor` to work with the appropriate abstractions.
7. Add a new payment provider without modifying existing order-processing logic.
8. Test the design with successful payments, failed payments, eligible refunds, and unsupported payment capabilities.

## Constraints

- Use plain Java only.
- Do not use frameworks, databases, or external libraries.
- Use interfaces and abstract classes where appropriate.
- Do not solve the problem by creating one interface per concrete class.
- Do not use `instanceof`, downcasting, or excessive type checks to distinguish payment methods.
- Do not throw `UnsupportedOperationException` merely because a subtype is forced to implement an operation it does not support.

## Interview Challenges

### Challenge 1: Adding a Payment Provider

Introduce a new payment provider that supports immediate payment but does not support refunds.

Determine which classes need to change and explain why the existing order-processing logic should remain unaffected.

### Challenge 2: Order Status

Explain how the system should distinguish between an order whose payment has succeeded and an order awaiting Cash on Delivery payment.

### Challenge 3: Refund Behaviour

A payment succeeds, but the provider rejects a refund request.

Explain how your design should represent this outcome without violating the contract of the refund operation.

## Learning Objectives

After completing this exercise, you should be able to:

- Identify LSP violations caused by unsupported operations.
- Design abstractions around genuine behavioural contracts and capabilities.
- Separate immediate payment, deferred payment, and refund behaviour.
- Use polymorphism without excessive type checks.
- Extend an existing payment system without breaking existing behaviour.
- Explain your design decisions clearly in technical interviews.

## Completion Criteria

- [ ] Existing LSP violations have been identified and resolved.
- [ ] Immediate payment methods work correctly.
- [ ] Cash on Delivery does not perform an immediate charge.
- [ ] Only eligible payment methods support refunds.
- [ ] Order status accurately reflects the payment lifecycle.
- [ ] New payment providers can be introduced without modifying existing processing logic.
- [ ] No unnecessary downcasting or `instanceof` checks are used.
- [ ] Tests cover successful and failed payment and refund scenarios.
- [ ] The design can be explained and justified in an interview.