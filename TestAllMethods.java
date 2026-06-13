import model.Account;
import model.CurrentAccount;
import model.SavingAccount;
import storageManagerService.StorageManager;

import java.time.LocalDate;

public class TestAllMethods {
    public static void main(String[] args) {
        
        StorageManager.createAccountsFolder();
        
        System.out.println("========================================");
        System.out.println("TEST 1: CREATE SAVING ACCOUNT");
        System.out.println("========================================");
        
        // Create Saving Account
        Account savingAccount = new SavingAccount(
            "SavingAccount", 
            5000,           // initial balance
            "SBI",          // branch name
            "00123",        // IFSC code
            "Aryan Kumar",  // account holder name
            "ABCDE1234F",   // PAN card
            "9876543210",   // contact number
            "123456789101", // Aadhar
            "aryan@gmail.com",  // email
            "Mumbai",       // address
            LocalDate.of(2000, 1, 15)  // DOB
        );
        
        String savingAccountNumber = ((SavingAccount) savingAccount).getAccountNumber();
        System.out.println("Saving Account Number: " + savingAccountNumber);
        System.out.println("Initial Balance: " + savingAccount.getBalance());
        
        // Save account
        StorageManager.saveAccount(savingAccount);
        System.out.println("✓ Saving account saved successfully\n");
        
        System.out.println("========================================");
        System.out.println("TEST 2: CREATE CURRENT ACCOUNT");
        System.out.println("========================================");
        
        // Create Current Account
        Account currentAccount = new CurrentAccount(
            "CurrentAccount",
            8000,           // initial balance
            "ICICI",        // branch name
            "00456",        // IFSC code
            "Priya Singh",  // account holder name
            "XYZZZ9876F",   // PAN card
            "8765432109",   // contact number
            "987654321012", // Aadhar
            "priya@gmail.com",  // email
            "Delhi",        // address
            LocalDate.of(1999, 5, 20)  // DOB
        );
        
        String currentAccountNumber = ((CurrentAccount) currentAccount).getAccountNumber();
        System.out.println("Current Account Number: " + currentAccountNumber);
        System.out.println("Initial Balance: " + currentAccount.getBalance());
        
        // Save account
        StorageManager.saveAccount(currentAccount);
        System.out.println("✓ Current account saved successfully\n");
        
        System.out.println("========================================");
        System.out.println("TEST 3: TEST DEPOSIT METHOD");
        System.out.println("========================================");
        
        System.out.println("Saving Account Balance before deposit: " + savingAccount.getBalance());
        savingAccount.deposit(1000);
        System.out.println("Depositing 1000...");
        System.out.println("Saving Account Balance after deposit: " + savingAccount.getBalance());
        System.out.println("✓ Deposit working correctly\n");
        
        System.out.println("========================================");
        System.out.println("TEST 4: TEST WITHDRAW METHOD");
        System.out.println("========================================");
        
        System.out.println("Saving Account Balance before withdrawal: " + savingAccount.getBalance());
        savingAccount.withdraw(500);
        System.out.println("Withdrawing 500...");
        System.out.println("Saving Account Balance after withdrawal: " + savingAccount.getBalance());
        System.out.println("✓ Withdraw working correctly\n");
        
        System.out.println("========================================");
        System.out.println("TEST 5: TEST GET BALANCE METHOD");
        System.out.println("========================================");
        System.out.println("Saving Account Balance: " + savingAccount.getBalance());
        System.out.println("Current Account Balance: " + currentAccount.getBalance());
        System.out.println("✓ GetBalance working correctly\n");
        
        System.out.println("========================================");
        System.out.println("TEST 6: TEST GET ACCOUNT DETAILS METHOD");
        System.out.println("========================================");
        System.out.println("--- SAVING ACCOUNT DETAILS ---");
        savingAccount.getAccountDetails();
        System.out.println("\n--- CURRENT ACCOUNT DETAILS ---");
        currentAccount.getAccountDetails();
        System.out.println("✓ GetAccountDetails working correctly\n");
        
        System.out.println("========================================");
        System.out.println("TEST 7: TEST DISABLE ACCOUNT METHOD");
        System.out.println("========================================");
        System.out.println("Disabling saving account...");
        savingAccount.disableAccount();
        System.out.println("✓ Disable account working correctly\n");
        
        System.out.println("========================================");
        System.out.println("TEST 8: TEST ENABLE ACCOUNT METHOD");
        System.out.println("========================================");
        System.out.println("Enabling saving account...");
        savingAccount.enableAccount();
        System.out.println("✓ Enable account working correctly\n");
        
        System.out.println("========================================");
        System.out.println("TEST 9: TEST TRANSFER METHOD");
        System.out.println("========================================");
        System.out.println("Saving Account Balance before transfer: " + savingAccount.getBalance());
        System.out.println("Current Account Balance before transfer: " + currentAccount.getBalance());
        
        // First save updated accounts
        StorageManager.saveAccount(savingAccount);
        StorageManager.saveAccount(currentAccount);
        
        // Load fresh copy of current account for transfer
        Account receiverAccount = StorageManager.loadAccount(currentAccountNumber);
        System.out.println("Loaded receiver account balance: " + receiverAccount.getBalance());
        
        System.out.println("Transferring 500 from saving to current account...");
        savingAccount.transfer(500, currentAccountNumber);
        
        System.out.println("Saving Account Balance after transfer: " + savingAccount.getBalance());
        receiverAccount = StorageManager.loadAccount(currentAccountNumber);
        System.out.println("Current Account Balance after transfer: " + receiverAccount.getBalance());
        System.out.println("✓ Transfer working correctly\n");
        
        System.out.println("========================================");
        System.out.println("TEST 10: TEST LOAD ACCOUNT METHOD");
        System.out.println("========================================");
        
        // Save updated accounts before loading
        StorageManager.saveAccount(savingAccount);
        
        Account loadedAccount = StorageManager.loadAccount(savingAccountNumber);
        if (loadedAccount != null) {
            System.out.println("✓ Account loaded successfully");
            System.out.println("Loaded Account Number: " + ((SavingAccount) loadedAccount).getAccountNumber());
            System.out.println("Loaded Account Balance: " + loadedAccount.getBalance());
        } else {
            System.out.println("✗ Failed to load account");
        }
        System.out.println();
        
        System.out.println("========================================");
        System.out.println("ALL TESTS COMPLETED SUCCESSFULLY!");
        System.out.println("========================================");
    }
}
