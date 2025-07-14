package com.autobots.java.lambda.bankApp2;

public class BannkService {
    public static boolean transfer(BankAccount from, BankAccount to, double amount){
        if (from.withdraw(amount)){
            double convertedSum = ExchangeRate.convert(amount, from.getCurrency(), to.getCurrency());
            to.deposit(convertedSum);
            from.addTransactions("Transfer out", amount);
            to.addTransactions("Transfer in", convertedSum);
            return true;
        }
        return false;
    }
}
