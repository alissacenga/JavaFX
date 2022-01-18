package com.example.demo;

public class Loan {
    private int nrOfYears;
    private double annualInterest;
    private double loanAmount;

    public int getNrOfYears() {
        return nrOfYears;
    }

    public void setNrOfYears(int nrOfYears) {
        this.nrOfYears = nrOfYears;
    }

    public double getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(double annualInterest) {
        this.annualInterest = annualInterest;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public Loan() {}

    public Loan(int nrOfYears, double annualInterest, double loanAmount) {
        this.nrOfYears = nrOfYears;
        this.annualInterest = annualInterest;
        this.loanAmount = loanAmount;
    }
    public double getMonthlyPayment() {
        /*
        * L = (MP / i) * [1 - (1 / (1+i)^n)]
        * L -> Loan Amount
        * MP -> Monthly Payment
        * i -> monthly interest
        * */
        // annual interest rate is in percentage, so we divide it by 100 and then divide it by 12
        double monthlyInterestRate = annualInterest / 1200;
        return loanAmount * monthlyInterestRate / (1 - 1/Math.pow(1 + monthlyInterestRate, nrOfYears*12));
    }
    public double getTotalPayment() {
        return getMonthlyPayment() * 12 * nrOfYears;
    }
}
