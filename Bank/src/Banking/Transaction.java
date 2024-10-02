package Banking;

import java.util.Date;

public class Transaction {

	private static int transactionCounter = 0;
	private int transactionId;
	private Date date;
	private float amount;
	private String type;
	
	public Transaction(String type, float amount) {
        this.transactionId = ++transactionCounter; 
        this.date = new Date();
        this.amount = amount;
        this.type = type;
    }
	
	public boolean isCreditTransaction() {
        return "DEPOSIT".equalsIgnoreCase(type) || "REWARD".equalsIgnoreCase(type);
    }

    public boolean isDebitTransaction() {
        return "WITHDRAWAL".equalsIgnoreCase(type) || "PURCHASE".equalsIgnoreCase(type);
    }
	
	@Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", date=" + date +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
