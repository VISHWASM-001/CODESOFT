package com;

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("✅ Deposit successful! Amount: " + amount);
     } else {
         System.out.println("❌ Invalid deposit amount.");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("✅ Withdrawal successful! Amount: " + amount);
     } else if (amount > balance) {
         System.out.println("❌ Insufficient balance.");
     } else {
         System.out.println("❌ Invalid withdrawal amount.");
     }
 }
}
