package com.autobots.java.lambda.bankApp;

public class Demir  extends  BankBase{
    private double balance = 500;

    public Demir(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
        addToAllBankRecords(this);
    }



    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount >= 500000){
            throw new IllegalArgumentException("Invalid amount, cant be deposit");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0 || amount >= 450000){
            throw new IllegalArgumentException("Invalid amount, cant be withdraw");
        } else {
            if (amount > balance){
                throw new IllegalArgumentException("Insufficient funds");
            }else{
                balance -= amount;
            }
        }
    }
}
