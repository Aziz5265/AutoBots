package com.autobots.java.lambda.bankApp;

public class BankDemo {
    public static void main(String[] args) throws Exception {
        Mbank alyaMbank = new Mbank(123456789876L, 444444444 );
        System.out.println(alyaMbank.getBalance());
        alyaMbank.deposit(10000);
        System.out.println(alyaMbank.getBalance());

        Optima ulugbekOptima = new Optima(123456789877L,444444445);
        System.out.println(ulugbekOptima.getBalance());

        iBank.transferFunds(alyaMbank, ulugbekOptima, 500);
        System.out.println(ulugbekOptima.getBalance());
        System.out.println(alyaMbank.getBalance());

        Demir zinaida = new Demir(111111111111L, 987654321);

//        iBank.transferFunds(zinaida, ulugbekOptima,  1000);
        System.out.println(zinaida.getBalance());
//        zinaida.withdraw(600000);

        BankBase.allBanksRecords.stream().filter(n -> n.getBalance()> 100).forEach(System.out::println);
        double allSumBanks = BankBase.allBanksRecords.stream().mapToDouble(BankBase::getBalance).sum();
        System.out.println(allSumBanks);
    }
}
