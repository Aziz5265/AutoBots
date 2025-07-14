package com.autobots.java.lambda.bankApp;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract  class BankBase implements iBank{

    private long accountNumber;
    private long routingNumber;

    public static  Set<BankBase> allBanksRecords = new HashSet<>();

    public BankBase(long accountNumber, long routingNumber) {

        if (Long.toString(accountNumber).length() != 12){
            throw new IllegalArgumentException("Account number must be 12 digits");
        }else if (Long.toString(routingNumber).length() != 9){
            throw new IllegalArgumentException("Routing number must be 9 digits");
        } else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }
    public static void addToAllBankRecords(BankBase bank) throws Exception {
        for (BankBase bankBase : allBanksRecords) {
            if (bankBase.getAccountNumber() == bank.getAccountNumber()){
                throw new Exception(bank.getAccountNumber() + ": account number already exist");
            }
            if (bankBase.getRoutingNumber() == bank.getRoutingNumber()){
                throw new Exception(bank.getRoutingNumber() + ": routing number is already exist");
            }
        }
        allBanksRecords.add(bank);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bankBase = (BankBase) o;
        return accountNumber == bankBase.accountNumber && routingNumber == bankBase.routingNumber;
    }

    @Override
    public String toString() {
        return "BankBase{" +
                "accountNumber=" + accountNumber +
                ", routingNumber=" + routingNumber +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, routingNumber);


    }
}
