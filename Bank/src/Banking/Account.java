package Banking;

public class Account {

	private static long accountNumberCounter = 1000000000L;
	private long accountNumber;
    private String accountHolderName;
    private float balance;
    private int totalRewardPoints; 

    public Account(String accountHolderName) {
    	this.accountNumber = accountNumberCounter++;
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = 0.0f; 
        this.totalRewardPoints = 0; 
    }
	
	public void updateBalance(float amount) {
	   balance += amount;
	}
	
	public void deposit(float amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(float amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	 @Override
	    public String toString() {
	        return "Account{" +
	                "accountNumber=" + accountNumber +
	                ", accountHolderName='" + accountHolderName + '\'' +
	                ", balance=" + balance +
	                ", totalRewardPoints=" + totalRewardPoints +
	                '}';
	    }
	
}
