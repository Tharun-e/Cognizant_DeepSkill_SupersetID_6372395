package AAAPattern;

public class bankaccount {
    private int currentBalance;
    public bankaccount(int startingAmount) {
        this.currentBalance = startingAmount;
    }
    public void addFunds(int amount) {
        if (amount > 0) {
            currentBalance += amount;
        }
    }
    public void withdrawFunds(int amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
        }
    }
    public int checkBalance() {
        return currentBalance;
    }
}
