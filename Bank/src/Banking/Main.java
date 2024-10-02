package Banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer1 = new Customer(1, "Alice", "password123");
        Customer customer2 = new Customer(2, "Bob", "password456");

        while (true) {
            System.out.println("Choose a customer to log in (1: Alice, 2: Bob, 0: Exit): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break; 
            }

            Customer currentCustomer = (choice == 1) ? customer1 : customer2;

            System.out.print("Enter password: ");
            String password = scanner.next();

            if (currentCustomer.login(currentCustomer.getCustomerId(), password)) {
                Account account = null; // Initialize account variable

                while (true) {
                    System.out.println("\nSelect an action:");
                    System.out.println("1: Create Account");
                    System.out.println("2: View Account Details");
                    System.out.println("3: Deposit Money");
                    System.out.println("4: Withdraw Money");
                    System.out.println("5: View Transaction History");
                    System.out.println("6: Create Gift Card");
                    System.out.println("7: Top-Up Gift Card");
                    System.out.println("8: Block Gift Card");
                    System.out.println("9: Logout");
                    System.out.print("Enter your choice: ");
                    int action = scanner.nextInt();

                    switch (action) {
                        case 1:
                        	System.out.print("Enter your name for the account: ");
                            scanner.nextLine(); 
                            String accountHolderName = scanner.nextLine(); 
                            account = new Account(accountHolderName);
                            currentCustomer.getAccountDetails().add(account);
                            System.out.println("Account created for " + accountHolderName + " with Account Number: " + account.getAccountNumber());
                            break;

                        case 2:
                            currentCustomer.viewAccountDetails(currentCustomer.getCustomerId(), password);
                            break;

                        case 3:
                            if (account != null) { // Check if the account exists
                                System.out.print("Enter amount to deposit: ");
                                float depositAmount = scanner.nextFloat();
                                account.deposit(depositAmount);
                                System.out.println("Balance after deposit: " + account.getBalance());
                            } else {
                                System.out.println("No account found. Please create an account first.");
                            }
                            break;

                        case 4:
                            if (account != null) { // Check if the account exists
                                System.out.print("Enter amount to withdraw: ");
                                float withdrawAmount = scanner.nextFloat();
                                account.withdraw(withdrawAmount);
                                System.out.println("Balance after withdrawal: " + account.getBalance());
                            } else {
                                System.out.println("No account found. Please create an account first.");
                            }
                            break;

                        case 5:
                            currentCustomer.viewTransactionHistory(currentCustomer.getCustomerId(), password);
                            break;

                        case 6:
                            currentCustomer.createGiftCard();
                            break;

                        case 7:
                            if (!currentCustomer.getGiftCards().isEmpty()) {
                                GiftCard giftCard = currentCustomer.getGiftCards().get(0);
                                System.out.print("Enter amount to top up the gift card: ");
                                int topUpAmount = scanner.nextInt();
                                System.out.println(giftCard.topUp(topUpAmount));
                            } else {
                                System.out.println("No gift cards available.");
                            }
                            break;

                        case 8:
                            if (!currentCustomer.getGiftCards().isEmpty()) {
                                GiftCard giftCard = currentCustomer.getGiftCards().get(0);
                                giftCard.blockGiftCard();
                            } else {
                                System.out.println("No gift cards available.");
                            }
                            break;

                        case 9:
                            currentCustomer.logout();
                            break;

                        default:
                            System.out.println("Invalid choice! Please try again.");
                    }

                    if (action == 9) {
                        break; // Logout and return to main menu
                    }
                }
            } else {
                System.out.println("Login failed! Please try again.");
            }
        }

        // Close the scanner
        scanner.close();
        System.out.println("Thank you for using the banking system!");
    }
}


//package Banking;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // Create some customers
//        Customer customer1 = new Customer(1, "Alice", "password123");
//        Customer customer2 = new Customer(2, "Bob", "password456");
//
//        // Login and interact with Customer 1
//        System.out.println("Logging in as Customer 1:");
//        if (customer1.login(1, "password123")) {
//            // Create an account
//            Account account1 = new Account(1234567890L, "Alice");
//            customer1.getAccountDetails().add(account1);
//            System.out.println("Account created for " + customer1.getCustomerName());
//
//            // Deposit money
//            account1.deposit(1000);
//            System.out.println("Balance after deposit: " + account1.getBalance());
//
//            // Withdraw money
//            account1.withdraw(200);
//            System.out.println("Balance after withdrawal: " + account1.getBalance());
//
//            // View account details
//            customer1.viewAccountDetails(1, "password123");
//
//            // Make a purchase
//            Purchase purchase1 = new Purchase(150, "Groceries");
//            customer1.getTransactions().add(new Transaction("PURCHASE", purchase1.getAmount()));
//            System.out.println("Purchase made: " + purchase1);
//
//            // View transaction history
//            customer1.viewTransactionHistory(1, "password123");
//
//            // Create a gift card
//            customer1.createGiftCard();
//
//            // Top up the gift card
//            GiftCard giftCard = customer1.getGiftCards().get(0);
//            System.out.print("Enter amount to top up the gift card: ");
//            int topUpAmount = scanner.nextInt();
//            System.out.println(giftCard.topUp(topUpAmount));
//
//            // Check gift card balance
//            System.out.println("Gift Card Balance: " + giftCard.getBalance());
//
//            // Block the gift card
//            giftCard.blockGiftCard();
//
//            // Attempt to top up the blocked gift card
//            System.out.print("Enter amount to top up the blocked gift card: ");
//            topUpAmount = scanner.nextInt();
//            System.out.println(giftCard.topUp(topUpAmount));
//
//            // Logout
//            customer1.logout();
//        }
//
//        // Login and interact with Customer 2
//        System.out.println("\nLogging in as Customer 2:");
//        if (customer2.login(2, "password456")) {
//            // Create an account
//            Account account2 = new Account(9876543210L, "Bob");
//            customer2.getAccountDetails().add(account2);
//            System.out.println("Account created for " + customer2.getCustomerName());
//
//            // Deposit money
//            account2.deposit(2000);
//            System.out.println("Balance after deposit: " + account2.getBalance());
//
//            // Withdraw money
//            account2.withdraw(500);
//            System.out.println("Balance after withdrawal: " + account2.getBalance());
//
//            // Make a purchase
//            Purchase purchase2 = new Purchase(300, "Electronics");
//            customer2.getTransactions().add(new Transaction("PURCHASE", purchase2.getAmount()));
//            System.out.println("Purchase made: " + purchase2);
//
//            // View account details
//            customer2.viewAccountDetails(2, "password456");
//
//            // View transaction history
//            customer2.viewTransactionHistory(2, "password456");
//
//            // Create a gift card
//            customer2.createGiftCard();
//
//            // Top up the gift card
//            GiftCard giftCard2 = customer2.getGiftCards().get(0);
//            System.out.print("Enter amount to top up the gift card: ");
//            int topUpAmount2 = scanner.nextInt();
//            System.out.println(giftCard2.topUp(topUpAmount2));
//
//            // Check gift card balance
//            System.out.println("Gift Card Balance: " + giftCard2.getBalance());
//
//            // Logout
//            customer2.logout();
//        }
//
//        // Close the scanner
//        scanner.close();
//    }
//}

