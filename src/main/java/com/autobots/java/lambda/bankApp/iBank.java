package com.autobots.java.lambda.bankApp;

public interface iBank {

    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);

    static void transferFunds(iBank sender, iBank recipient, double transferAmount){
        sender.withdraw(transferAmount);
        recipient.deposit(transferAmount);
    }
}
