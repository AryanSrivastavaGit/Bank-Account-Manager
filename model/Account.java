package model;

public interface Account{
    void deposit(double amount);
    void withdraw(double amount);
    double getBalance();
    void transfer(double amount, Account toAccount);
    void getAccountDetails();
    void disableAccount();
    void enableAccount();
    void changePassword();
}