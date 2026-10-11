enum paymentStatus{
    DONE,
    PENDING,
    FAILED
}

enum refundStatus{
    REFUND,
    PENDING,
    FAILED
}

enum order{
    PLACED,
    INTRANSIT,
    FAILED,
    COMPLETED
}

interface PaymentMethod{

    public paymentStatus pay();

}

interface refundable extends PaymentMethod{

    public refundStatus initiateRefund();

}

class CreditCardPayment implements PaymentMethod{

    @Override
    

}