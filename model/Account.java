package model;

import java.io.Serializable;

public interface Account extends Serializable {
    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();

    void transfer(double amount, String toAccount);

    void getAccountDetails();

    void disableAccount();

    void enableAccount();

    void changePassword(String oldPassword, String newPassword);
}