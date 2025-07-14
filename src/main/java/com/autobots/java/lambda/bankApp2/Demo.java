package com.autobots.java.lambda.bankApp2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    static Scanner scanner  = new Scanner(System.in);
    static Map<String, Client> clients = new HashMap<>();
    public static void main(String[] args) {

        Client asan = new Client("Asan", "123");

        DepositAccount asanDep = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCred = new CreditAccount(asan, Currency.EUR);

        asan.addAccount(asanCred);
        asan.addAccount(asanDep);
        System.out.println(asan.getClientID());

        clients.put(asan.getClientID(),asan);

        System.out.println("__________Welcome to MBank_________");
        System.out.print("Plz enter client ID");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);
        if (client == null){
            System.out.println("Client not found");
            return;
        }
        System.out.print("Please enter PIN Code");
        String pinCode = scanner.nextLine();
        if (!client.authenticate(pinCode)){
            System.out.println("U entered wrong pincode");
            return;
        }
        System.out.println(client.getFullName() + "Welcome to MBANK");

        while (true){
            System.out.println("1. View accounts");
            System.out.println("2. Transfer between acc");
            System.out.println("3. show check");
            System.out.println("0. Cancel system");

            String choice = scanner.nextLine();
            switch (choice){
                case "1" :
                    for (BankAccount bankAccount : client.getAccounts()){
                        System.out.printf("%s | %s | balance: %.2f %s\n ",
                                bankAccount.getClass().getSimpleName(),
                                bankAccount.getAccountNumber(),
                                bankAccount.getBalance(), bankAccount.getCurrency());
                    }
                    break;
                case "2" :
                    System.out.print("Vvedite nimer sheta");
                    String fromID = scanner.nextLine();
                    System.out.println("Vvedite nomer poluchatelya");
                    String toID = scanner.nextLine();
                    System.out.print("vvedite summu");
                    double amount = Double.parseDouble(scanner.nextLine());
                    BankAccount from = findAccount(fromID);
                    BankAccount to = findAccount(toID);
                    if (from !=to && to != null){
                        boolean result =BannkService.transfer(from, to , amount);
                        System.out.println(result ? "Uspeshno" : "Oshibka perevoda");
                    }else {
                        System.out.println("Sheta ne naydeni");
                    }
                    break;
                case "3":
                    for (BankAccount bankAccount : client.getAccounts()){
                        System.out.println("\n == check po shety " + bankAccount.getAccountNumber());
                        for (Transaction transaction : bankAccount.getTransactions()){
                            System.out.println(transaction);
                        }
                    }
                    break;
                case "0":
                    System.out.println("Vyxod...");
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        }

    }
    public static BankAccount findAccount(String accountNumber){
        for (Client client : clients.values()){
            for (BankAccount bankAccount : client.getAccounts()){
                if (bankAccount.getAccountNumber().equals(accountNumber)){
                    return bankAccount;
                }
            }
        }return null;
    }
}
