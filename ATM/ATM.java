package com;

import java.util.*;
class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void start() {
     Scanner sc = new Scanner(System.in);
     int choice;
     do {
         System.out.println("\n===== ATM Menu =====");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
         System.out.print("Enter choice: ");
         choice = sc.nextInt();

         switch (choice) {
             case 1:
                 System.out.println("💰 Current Balance: " + account.getBalance());
                 break;
             case 2:
                 System.out.print("Enter deposit amount: ");
                 double depositAmount = sc.nextDouble();
                 account.deposit(depositAmount);
                 break;
             case 3:
                 System.out.print("Enter withdrawal amount: ");
                 double withdrawAmount = sc.nextDouble();
                 account.withdraw(withdrawAmount);
                 break;
             case 4:
                 System.out.println("🚪 Exiting ATM. Thank you!");
                 break;
             default:
                 System.out.println("❌ Invalid choice, try again.");
         }
     } while (choice != 4);

     sc.close();
 }
}