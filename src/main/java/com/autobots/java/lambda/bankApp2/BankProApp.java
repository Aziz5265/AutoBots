package com.autobots.java.lambda.bankApp2;

import java.lang.ref.Cleaner;
import java.util.HashMap;
import java.util.Map;

public class BankProApp {
    private static final Map<String, Client> clients = new HashMap<>();
    public static void main(String[] args) {


        Client asan = new Client("Asan", "123");

        DepositAccount asanDep = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCred = new CreditAccount(asan,Currency.EUR);

        asan.addAccount(asanCred);
        asan.addAccount(asanDep);

        clients.put(asan.getClientID(),asan);
    }
}
