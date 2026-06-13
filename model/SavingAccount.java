package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import exceptionHandling.InvalidAmountException;
import storageManagerService.StorageManager;

public class SavingAccount implements Account {
    private String accountNumber;
    private String password;
    private String accountType;
    private double balance;
    private String branchName;
    private String ifscCode;

    private String accountHolderName;
    private String panCardNumber;
    private String contactNumber;
    private String aadharCardNumber;
    private String email;
    private String address;
    private LocalDate dateOfBirth;

    private LocalDateTime accountOpeningDateTime;
    private LocalDateTime accountClosingDateTime;
    private boolean accountStatus;

    private List<Transactions> transactions;

    private double interestRate;
    private double minimumBalance;
    private double transactionLimit;

    public SavingAccount(String accountType, double balance, String branchName, String ifscCode,
            String accountHolderName, String panCardNumber, String contactNumber, String aadharCardNumber,
            String email, String address, LocalDate dateOfBirth) {
        this.accountNumber = generateAccountNumber();
        this.password = generatePassword(panCardNumber, dateOfBirth);
        this.accountType = accountType;
        this.balance = balance;
        this.branchName = branchName;
        this.ifscCode = ifscCode;
        this.accountHolderName = accountHolderName;
        this.panCardNumber = panCardNumber;
        this.contactNumber = contactNumber;
        this.aadharCardNumber = aadharCardNumber;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.accountOpeningDateTime = LocalDateTime.now();
        this.accountClosingDateTime = null;
        this.accountStatus = true;
        this.transactions = new ArrayList<>();
        this.interestRate = 4.0; // Example interest rate for saving account
        this.minimumBalance = 0; // Example minimum balance for saving account
        this.transactionLimit = 20000.0; // Example transaction limit for saving account
    }

    private String generatePassword(String panCardNumber, LocalDate dateOfBirth) {
        return panCardNumber.substring(panCardNumber.length() - 4) + dateOfBirth.toString().substring(0, 4);
    }

    private String generateAccountNumber() {
        return System.currentTimeMillis() + "";
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void deposit(double amount) {
        // Implementation for deposit
        if (amount < 0) {
            throw new InvalidAmountException("Amount should be greater than 0");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        // Implementation for withdraw
        if (amount > balance) {
            throw new InvalidAmountException("Withdrawl amount should be less than or equal to balance");
        }
        balance -= amount;
    }

    @Override
    public double getBalance() {
        // Implementation for getting balance
        return balance;
    }

    @Override
    public void transfer(double amount, String toAccount) {
        if (amount < 0) {
            throw new InvalidAmountException("Amount should be greater than 0");
        }
        
        if (amount > balance) {
            throw new InvalidAmountException("Insufficient balance for transfer");
        }

        try {
            Account acc = StorageManager.loadAccount(toAccount);
            acc.deposit(amount);
            this.balance -= amount;
            System.out.println("Transfer successful. Amount transferred: " + amount);
        } catch (Exception e) {
            System.out.println("Receiver account not valid: " + e);
        }
    }

    @Override
    public void getAccountDetails() {
        System.out.println("Account type:" + accountType);
        System.out.println("initial balance: " + balance);
        System.out.println("branch name:" + branchName);
        System.out.println("IFSC code:" + ifscCode);
        System.out.println("account holder name:" + accountHolderName);
        System.out.println("PAN card number:" + panCardNumber);
        System.out.println("contact number:" + contactNumber);
        System.out.println("Aadhar card number:" + aadharCardNumber);
        System.out.println("email:" + email);
        System.out.println("date of birth (YYYY-MM-DD):" + dateOfBirth);
        System.out.println("Address: " + address);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(password)) {
            password = newPassword;
            System.out.println("Password changed successfully");
        } else {
            System.out.println("Wrong Password");
        }
    }

    @Override
    public void disableAccount() {
        this.accountStatus = false;
    }

    @Override
    public void enableAccount() {
        this.accountStatus = true;
    }

}