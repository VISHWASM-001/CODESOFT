package com;

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000); // initial balance
        ATM atm = new ATM(account);
        atm.start();
    }
}