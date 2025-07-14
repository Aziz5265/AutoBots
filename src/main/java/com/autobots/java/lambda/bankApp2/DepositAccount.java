package com.autobots.java.lambda.bankApp2;

public class DepositAccount extends BankAccount{

    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency );
    }

    @Override
    void deposit(double amount) {
    balance += amount;
    addTransactions("Deposit", amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance){
            balance -= amount;
            addTransactions("Withdraw" , amount);
            return true;
        }
        return false;
    }
}
