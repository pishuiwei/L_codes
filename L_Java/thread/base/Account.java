package base;

public class Account {

    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amt) {
        balance = balance + amt;
    }

    public void withdraw(double amt){
        balance = balance - amt;
    }

}
