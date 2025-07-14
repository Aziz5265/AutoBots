package com.autobots.java.lambda.bankApp2;

public class CreditAccount extends BankAccount{

    private final double creditLimit = 1000;

    public CreditAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        addTransactions("Deposit", amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance + creditLimit){
            balance -= amount;
            addTransactions("Withdraw" , amount);
            return true;
        }
        return false;
    }
}
