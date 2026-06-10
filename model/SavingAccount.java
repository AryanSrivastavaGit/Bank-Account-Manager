package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        return panCardNumber.substring(panCardNumber.length()-4) + dateOfBirth.toString().substring(0, 4);
    }

    private String generateAccountNumber() {
        return System.currentTimeMillis()+"";
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
    public void getAccountDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAccountDetails'");
    }

    @Override
    public void changePassword() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePassword'");
    }
    
    @Override
    public void disableAccount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'disableAccount'");
    }

	@Override
	public void enableAccount() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'enableAccount'");
	}

}