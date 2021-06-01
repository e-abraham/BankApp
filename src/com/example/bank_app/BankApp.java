package com.example.bank_app;

public class BankApp {
    public static void main(String[] args) {
        BankAccount customerAcct = new BankAccount(105.00, 40.00);
        customerAcct.getCheckingBalance();
        customerAcct.getSavingsBalance();
        customerAcct.checkingWithdraw(5.00);
        customerAcct.savingsWithdraw(100.00);
        customerAcct.transferCheckToSav(15.45);
        customerAcct.transferSavToCheck(10.00);
        customerAcct.depositChecking(50.00);
        customerAcct.depositSavings(80.00);
    }
}
