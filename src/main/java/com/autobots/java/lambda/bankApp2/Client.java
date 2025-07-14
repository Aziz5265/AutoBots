package com.autobots.java.lambda.bankApp2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {
    public final String fullName;
    public final String clientID;
    public final String pin;
    public final List<BankAccount> accounts = new ArrayList<>();

    public Client(String fullName, String pin) {
        this.fullName = fullName;
        this.pin = pin;
        this.clientID = String.valueOf(UUID.randomUUID());
    }

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);

    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public String getClientID() {
        return clientID;
    }

    public String getFullName() {
        return fullName;
    }
}
