package air;



public class Payment {
    private double paymentAmt;

    public Payment(double paymentAmt) {
        this.paymentAmt = paymentAmt;
    }

    public boolean confirmPayment(double amt) {
        return amt == paymentAmt;
    }

    public double getPaymentAmt() {
        return paymentAmt;
    }
}
