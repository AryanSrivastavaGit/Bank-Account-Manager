package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrentAccount implements Account {
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
    private String accountStatus;

    private List<Transactions> transactions;    

    private double interestRate;
    private double minimumBalance;

    public CurrentAccount(String accountType, double balance, String branchName, String ifscCode,
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
        this.accountStatus = "Active";
        this.transactions = new ArrayList<>();
        this.interestRate = 0.0; // Current accounts typically do not earn interest
        this.minimumBalance = 1000.0; // Example minimum balance for current account        
    }

    private String generatePassword(String panCardNumber2, LocalDate dateOfBirth2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generatePassword'");
    }

    private String generateAccountNumber() {
        return "";
    }

    @Override
    public void deposit(double amount) {
        // Implementation for deposit
    }

    @Override
    public void withdraw(double amount) {
        // Implementation for withdraw
    }

    @Override
    public double getBalance() {
        // Implementation for getting balance
        return 0;
    }

    @Override
    public void transfer(double amount, Account toAccount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'transfer'");
    }

    @Override
    public void disableAccount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disableAccount'");
    }
}