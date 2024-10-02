package Banking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Customer {

	private int customerId;
	private String customerName;
	private float balance;
	private String password;
	private boolean loggedIn;
	private static HashMap<Integer,String> customerData = new HashMap<>();
    private List<Transaction> transactions;
    private List<Account> accountDetails;
    private List<GiftCard> giftCards;
    
	public Customer(int customerId,String customerName,String password) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.password = encryptPassword(password);
	    this.balance = 0.0f;
	    this.loggedIn = false;
	    customerData.put(customerId, this.password);
		this.transactions = new ArrayList<>();
		this.accountDetails = new ArrayList<>();
		this.giftCards = new ArrayList<>();
		
	}
	
	
	private String encryptPassword(String password) {
		StringBuilder encrypted = new StringBuilder();
		for(char c : password.toCharArray()) {
			encrypted.append((char) ( c + 1));
		}
		
		return new String(encrypted);
	}

	public boolean login(int customerId,String password) {
		
		if(customerData.containsKey(customerId)) {
			if(customerData.get(customerId).equals(encryptPassword(password))) {
			this.loggedIn = true;
			System.out.println("Login successful for customer: " + customerId);
			return true;
		  }
		}
		System.out.println("Login Failed: " + customerId);
		return false;
		
	}
	
	public void logout() {
		if(loggedIn) {
			this.loggedIn = false;
			System.out.println("Logout successful for customer: " + customerId);
		}else {
			System.out.println("No user is currently logged in.");
		}
		
	}
	public void viewTransactionHistory(int customerId,String password){
		
		if(login(customerId,password)) {
			
			if(transactions.isEmpty()) {
				System.out.println("No Transactions!!");
			}else {
				for (Transaction transaction : transactions) {
                    System.out.println(transaction.toString()); 
                }
			}
		}else {
			System.out.println("User is not logged In!");
		}
		
	}
	
	public void viewAccountDetails(int customerId,String password) {
		
		if(login(customerId,password)) {
			for(Account account : accountDetails) {
				System.out.println("Account Number :" + account.getAccountNumber());
				System.out.println("Name :" + account.getAccountHolderName());
				System.out.println("Balance :" + account.getBalance());
			}
		}
	}

	public void createGiftCard(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Pin for Your Gift Card");
		int pin = sc.nextInt();
		GiftCard giftcard = new GiftCard(customerId,pin);
		giftCards.add(giftcard);
		System.out.println("Gift Card created Successfully");
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public static HashMap<Integer, String> getCustomerData() {
		return customerData;
	}

	public static void setCustomerData(HashMap<Integer, String> customerData) {
		Customer.customerData = customerData;
	}

	public List<GiftCard> getGiftCards() {
	    return giftCards;
	}

	public List<Account> getAccountDetails() {
	    return accountDetails;
	}

}


