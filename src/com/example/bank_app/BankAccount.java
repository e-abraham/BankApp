package com.example.bank_app;

public class BankAccount {
    // instance fields
    private double checkingBalance = 0.00;
    private double savingsBalance = 0.00;
    private final double checkingOpeningDeposit;
    private final double savingsOpeningDeposit;

    // Bank Account constructor
    public BankAccount(double checkingDeposit, double savingsDeposit){
        checkingOpeningDeposit = checkingDeposit;
        savingsOpeningDeposit = savingsDeposit;
        checkingBalance += checkingOpeningDeposit;
        savingsBalance += savingsOpeningDeposit;
    }

    // get balance methods
    public double getCheckingBalance(){
        System.out.println("Checking Account Balance: " + checkingBalance);
        return checkingBalance;
    }
    public double getSavingsBalance(){
        System.out.println("Savings Account Balance: " + savingsBalance);
        return savingsBalance;
    }

    // withdrawal methods
    public void checkingWithdraw(double withdraw){
        System.out.println("Withdraw from Checking: " + withdraw);
        if (withdraw > checkingBalance && withdraw > savingsBalance){
            System.out.println("Insufficient funds to make withdrawal.");
        } else if (withdraw > checkingBalance && withdraw <= savingsBalance){
            System.out.println("Insufficient funds, transfer from savings to make withdrawal.");
        } else {
            checkingBalance -= withdraw;
            System.out.println("Withdrawal successful.");
        }
        this.getCheckingBalance();
    }
    public void savingsWithdraw(double withdraw){
        System.out.println("Withdraw from Savings: " + withdraw);
        if (withdraw > savingsBalance && withdraw > checkingBalance){
            System.out.println("Insufficient funds to make withdrawal.");
        } else if (withdraw > savingsBalance && withdraw <= checkingBalance){
            System.out.println("Insufficient funds, transfer from checking to make withdrawal.");
        } else {
            savingsBalance -= withdraw;
            System.out.println("Withdrawal successful.");
        }
        this.getSavingsBalance();
    }

    // transfer methods
    public void transferCheckToSav(double transferAmount){
        System.out.println("Transfer " + transferAmount + " from checking to savings.");
        if (transferAmount <= checkingBalance){
            checkingBalance -= transferAmount;
            savingsBalance += transferAmount;
            System.out.println("Transfer complete.");
            this.getCheckingBalance();
            this.getSavingsBalance();
        } else {
            System.out.println("Insufficient funds to make transfer.");
        }
    }
    public void transferSavToCheck(double transferAmount){
        System.out.println("Transfer " + transferAmount + " from savings to checking.");
        if (transferAmount <= savingsBalance){
            savingsBalance -= transferAmount;
            checkingBalance += transferAmount;
            System.out.println("Transfer complete.");
            this.getSavingsBalance();
            this.getCheckingBalance();
        } else {
            System.out.println("Insufficient funds to make transfer.");
        }
    }

    // deposit methods
    public void depositChecking(double deposit){
        System.out.println("Deposit to Checking: " + deposit);
        checkingBalance += deposit;
        this.getCheckingBalance();
    }
    public void depositSavings(double deposit){
        System.out.println("Deposit to Savings: " + deposit);
        savingsBalance += deposit;
        this.getSavingsBalance();
    }
}
