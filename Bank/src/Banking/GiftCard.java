package Banking;

import java.util.ArrayList;
import java.util.List;

public class GiftCard{

	private int cardId;
    private int pin;
	private float balance;
	private boolean isBlocked;
	private List<Transaction> transactions;
	
	public GiftCard(int customerId,int pin) {
		this.cardId = customerId;
		this.pin = pin;
		this.balance = 0.0f;
		this.isBlocked = false;
		 this.transactions = new ArrayList<>();
	}
	
	public String topUp(int amount) {
		if(isBlocked) {
			return ("your Card has been Blocked!!");
		}
		
		if(amount <= 0){
			return "Amount Must be Positive";
		}
		
		balance += amount;
		Transaction transaction = new Transaction("Top-Up" , amount);
		transactions.add(transaction);
		
		return "Top-Up Succesful Your Balance is : " + balance;
	}
	
	public boolean verifyPin(int pin) {
		if(this.pin == pin) {
			return true;
		}
		return false;	
	}
	
	public void blockGiftCard(){
	   this.isBlocked = true;
	   System.out.println("Gift Card has been blocked.");
	}
	
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}



