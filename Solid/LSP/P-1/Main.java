enum PaymentStatus {
    NOT_STARTED, PENDING, SUCCEEDED, FAILED, AWAITING_COLLECTION
}

enum RefundStatus {
    NOT_REQUESTED, PENDING, SUCCEEDED, REJECTED
}

enum OrderStatus {
    PLACED, PAYMENT_PENDING, AWAITING_PAYMENT,
    CONFIRMED, PAYMENT_FAILED, IN_TRANSIT, COMPLETED, CANCELLED
}


class PaymentResult {
    private final PaymentStatus status;
    private final String transactionId;
    private final String message;

    public PaymentResult(PaymentStatus status, String transactionId, String message) {
        // TODO
    }

    public PaymentStatus getStatus() { /* TODO */ return null; }
    public String getTransactionId() { /* TODO */ return null; }
    public String getMessage() { /* TODO */ return null; }
}

class RefundResult {
    private final RefundStatus status;
    private final String message;

    public RefundResult(RefundStatus status, String message) {
        // TODO
    }

    public RefundStatus getStatus() { /* TODO */ return null; }
    public String getMessage() { /* TODO */ return null; }
}


interface PaymentMethod {
    PaymentResult initiatePayment();
}

interface ImmediatePayment extends PaymentMethod {
    PaymentResult payNow();

    @Override
    default PaymentResult initiatePayment() {
        // TODO
        return null;
    }
}

interface DeferredPayment extends PaymentMethod {
    PaymentResult scheduleCollection();

    @Override
    default PaymentResult initiatePayment() {
        // TODO
        return null;
    }
}

interface Refundable {
    RefundResult refund(String transactionId);
}


class CreditCardPayment implements ImmediatePayment, Refundable {
    @Override
    public PaymentResult payNow() {
        // TODO
        return null;
    }

    @Override
    public RefundResult refund(String transactionId) {
        // TODO
        return null;
    }
}

class UPIPayment implements ImmediatePayment, Refundable {
    private final boolean paymentSucceeds;
    private final boolean refundAccepted;

    public UPIPayment(boolean paymentSucceeds, boolean refundAccepted) {
        // TODO
    }

    @Override
    public PaymentResult payNow() {
        // TODO
        return null;
    }

    @Override
    public RefundResult refund(String transactionId) {
        // TODO
        return null;
    }
}

class CashOnDelivery implements DeferredPayment {
    @Override
    public PaymentResult scheduleCollection() {
        // TODO
        return null;
    }
}

class WalletPayment implements ImmediatePayment {
    @Override
    public PaymentResult payNow() {
        // TODO
        return null;
    }
}


class Order {
    private final String id;
    private OrderStatus orderStatus = OrderStatus.PLACED;
    private PaymentStatus paymentStatus = PaymentStatus.NOT_STARTED;
    private RefundStatus refundStatus = RefundStatus.NOT_REQUESTED;
    private String transactionId;

    public Order(String id) {
        // TODO
    }

    public String getId() { /* TODO */ return null; }
    public OrderStatus getOrderStatus() { /* TODO */ return null; }
    public PaymentStatus getPaymentStatus() { /* TODO */ return null; }
    public RefundStatus getRefundStatus() { /* TODO */ return null; }
    public String getTransactionId() { /* TODO */ return null; }

    public void applyPaymentResult(PaymentResult result) {
        // TODO
    }

    public void applyRefundResult(RefundResult result) {
        // TODO
    }

    public void printStatus() {
        // TODO
    }
}


class OrderProcessor {
    public void processPayment(Order order, PaymentMethod method) {
        // TODO
    }

    public void processRefund(Order order, Refundable method) {
        // TODO
    }
}
