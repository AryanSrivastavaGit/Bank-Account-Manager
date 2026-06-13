import model.Account;
import model.CurrentAccount;
import model.SavingAccount;
import storageManagerService.StorageManager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StorageManager.createAccountsFolder();

        Scanner sc = new Scanner(System.in);

        System.out.println("Press 1 to create a saving account");
        System.out.println("Press 2 to create a current account");
        System.out.println("Press 3 to deposit money");
        System.out.println("Press 4 to withdraw money");
        System.out.println("Press 5 to check balance");
        System.out.println("Press 6 to transfer money");
        System.out.println("Press 7 to disable account");
        System.out.println("Press 8 to enable account");
        System.out.println("Press 9 to exit");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                // Saving account creation
                System.out.println("Enter account type:");
                String accountType = sc.nextLine();
                System.out.println("Enter initial balance:");
                double balance = sc.nextDouble();
                System.out.println("Enter branch name:");
                String branchName = sc.next();
                System.out.println("Enter IFSC code:");
                String ifscCode = sc.next();
                System.out.println("Enter account holder name:");
                String accountHolderName = sc.nextLine();
                System.out.println("Enter PAN card number:");
                String panCardNumber = sc.next();
                System.out.println("Enter contact number:");
                String contactNumber = sc.next();
                System.out.println("Enter Aadhar card number:");
                String aadharCardNumber = sc.next();
                System.out.println("Enter email:");
                String email = sc.next();
                System.out.println("Enter address:");
                String address = sc.nextLine();
                System.out.println("Enter date of birth (YYYY-MM-DD):");
                LocalDate dateOfBirth = LocalDate.parse(sc.next());

                Account savingAccount = new SavingAccount(accountType, balance, branchName, ifscCode,
                        accountHolderName, panCardNumber, contactNumber, aadharCardNumber,
                        email, address, dateOfBirth);

                StorageManager.saveAccount(savingAccount);

                break;
            case 2:
                //Current Account creation
                System.out.println("Enter account type:");
                String accountType1 = sc.next();
                System.out.println("Enter initial balance:");
                double balance1 = sc.nextDouble();
                System.out.println("Enter branch name:");
                String branchName1 = sc.next();
                System.out.println("Enter IFSC code:");
                String ifscCode1 = sc.next();
                System.out.println("Enter account holder name:");
                String accountHolderName1 = sc.nextLine();
                System.out.println("Enter PAN card number:");
                String panCardNumber1 = sc.next();
                System.out.println("Enter contact number:");
                String contactNumber1 = sc.next();
                System.out.println("Enter Aadhar card number:");
                String aadharCardNumber1 = sc.next();
                System.out.println("Enter email:");
                String email1 = sc.next();
                System.out.println("Enter address:");
                String address1 = sc.nextLine();
                System.out.println("Enter date of birth (YYYY-MM-DD):");
                LocalDate dateOfBirth1 = LocalDate.parse(sc.next());
                Account currentAccount = new CurrentAccount(accountType1, balance1, branchName1, ifscCode1,
                        accountHolderName1, panCardNumber1, contactNumber1, aadharCardNumber1,
                        email1, address1, dateOfBirth1);

                StorageManager.saveAccount(currentAccount);
                break;
            case 3:
                // Implementation for depositing money
                System.out.println("Enter account number:");
                String accountNumber = sc.next();
                System.out.println("Enter amount to deposit:");
                double amountToDeposit = sc.nextDouble();

                Account account = StorageManager.loadAccount(accountNumber);

                account.deposit(amountToDeposit);

                StorageManager.saveAccount(account);

                break;
            case 4:
                // Implementation for withdrawing money
                System.out.println("Enter account number:");
                String accountNumber2 = sc.next();
                System.out.println("Enter amount to withdrawl:");
                double amountToWithdraw = sc.nextDouble();

                Account account2 = StorageManager.loadAccount(accountNumber2);

                account2.withdraw(amountToWithdraw);

                StorageManager.saveAccount(account2);
                break;
            case 5:
                // Implementation for checking balance
                System.out.println("Enter account number:");
                String accountNumber3 = sc.next();

                Account account3 = StorageManager.loadAccount(accountNumber3);

                System.out.println(account3.getBalance());

                break;
            case 6:
                // Implementation for transferring money
                System.out.println("From Account No: ");
                String fromAccount = sc.next();
                System.out.print("To Account No: ");
                String toAccount = sc.next();
                System.out.print("Amount to transfer: ");
                double transferAmount = sc.nextDouble();

                Account to = StorageManager.loadAccount(fromAccount);
                to.transfer(transferAmount, toAccount);

                break;
            case 7:
                // Implementation for disabling account
                System.out.print("Account to disable: ");
                String accDisable = sc.next();
                Account disable = StorageManager.loadAccount(accDisable);
                disable.disableAccount();
                break;
            case 8:
                // Implementation for enabling account
                System.out.print("Account to enable: ");
                String accEnable = sc.next();
                Account enable = StorageManager.loadAccount(accEnable);
                enable.enableAccount();
                break;
            case 9:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

    }
}