import model.Account;
import model.CurrentAccount;
import model.SavingAccount;

import java.time.LocalDate;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        System.out.println("Press 1 to create a saving account");
        System.out.println("Press 2 to create a current account");
        System.out.println("Press 3 to deposit money");
        System.out.println("Press 4 to withdraw money");
        System.out.println("Press 5 to check balance");
        System.out.println("Press 6 to transfer money");
        System.out.println("Press 7 to disable account");
        System.out.println("Press 8 to enable account");
        System.out.println("Press 9 to exit");

        switch (choice) {
            case 1:
                System.out.println("Enter account type:");
                String accountType = sc.next();
                System.out.println("Enter initial balance:");
                double balance = sc.nextDouble();
                System.out.println("Enter branch name:");
                String branchName = sc.next();
                System.out.println("Enter IFSC code:");
                String ifscCode = sc.next();
                System.out.println("Enter account holder name:");
                String accountHolderName = sc.next();
                System.out.println("Enter PAN card number:");
                String panCardNumber = sc.next();
                System.out.println("Enter contact number:");
                String contactNumber = sc.next();
                System.out.println("Enter Aadhar card number:");
                String aadharCardNumber = sc.next();
                System.out.println("Enter email:");
                String email = sc.next();
                System.out.println("Enter address:");
                String address = sc.next();
                System.out.println("Enter date of birth (YYYY-MM-DD):");
                LocalDate dateOfBirth = LocalDate.parse(sc.next());

                Account savingAccount = new SavingAccount(accountType, balance, branchName, ifscCode,
                        accountHolderName, panCardNumber, contactNumber, aadharCardNumber,
                        email, address, dateOfBirth);
                break;
            case 2:
                System.out.println("Enter account type:");
                String accountType1 = sc.next();
                System.out.println("Enter initial balance:");
                double balance1 = sc.nextDouble();
                System.out.println("Enter branch name:");
                String branchName1 = sc.next();
                System.out.println("Enter IFSC code:");
                String ifscCode1 = sc.next();   
                System.out.println("Enter account holder name:");
                String accountHolderName1 = sc.next();
                System.out.println("Enter PAN card number:");
                String panCardNumber1 = sc.next();
                System.out.println("Enter contact number:");
                String contactNumber1 = sc.next();
                System.out.println("Enter Aadhar card number:");
                String aadharCardNumber1 = sc.next();
                System.out.println("Enter email:");
                String email1 = sc.next();
                System.out.println("Enter address:");
                String address1 = sc.next();
                System.out.println("Enter date of birth (YYYY-MM-DD):");
                LocalDate dateOfBirth1 = LocalDate.parse(sc.next());
                Account currentAccount = new CurrentAccount(accountType1, balance1, branchName1, ifscCode1,
                        accountHolderName1, panCardNumber1, contactNumber1, aadharCardNumber1,
                        email1, address1, dateOfBirth1);
                break;
            case 3:
                // Implementation for depositing money
                System.out.println("Enter account number:");
                String accountNumber = sc.next();
                System.out.println("Enter amount to deposit:");
                double amountToDeposit = sc.nextDouble();
                
                break;
            case 4:
                // Implementation for withdrawing money
                break;
            case 5:
                // Implementation for checking balance
                break;
            case 6:
                // Implementation for transferring money
                break;
            case 7:
                // Implementation for disabling account
                break;
            case 8:
                // Implementation for enabling account
                break;
            case 9:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
    }
}