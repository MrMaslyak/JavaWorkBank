import java.util.ArrayList;

public class Bank {
    private boolean ban;
    private ArrayList<BankAccount> accounts;


    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public BankAccount createAccount(String user, int indexUser, int initialDeposit , double creditLimit) {
        BankAccount newAccount = new BankAccount(user, indexUser, initialDeposit , creditLimit);
        accounts.add(newAccount);
        System.out.println("Bank created new account for user: " + user + " with initial deposit: " + initialDeposit + "$");
        return newAccount;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("We register your account in our Bank - " + account.getUser() + " with initial deposit: " + account.getMoney() + "$"); ;
    }

    public void printAllAccounts() {
        System.out.println("-----------------------------------");
        System.out.println("All accounts in the bank:");
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getUser() + ", Balance: " + account.getMoney() + "$, Index: " + account.getIndexUser());
        }
        System.out.println("-----------------------------------");
    }
    public void banAccount(BankAccount account){
        this.accounts.remove(account);
        System.out.println("Account " + account.getUser() + " is banned");
    }
    public void unbanAccount(BankAccount account){
        this.accounts.add(account);
        System.out.println("Account " + account.getUser() + " is unbanned");
    }
    public void printStaticAccount(BankAccount account){
        System.out.println("User: " + account.getUser() + " has balance: " + account.getMoney() + "$"+" has credit: " + account.getCredit() + "$");
    }
    public void changeCredit(BankAccount account, double credit) {
        account.setCredit(credit);
        System.out.println("Bank changed a credit of " + credit + "$ to user: " + account.getUser());
    }
    public void removeCredit(BankAccount account) {
        account.setCredit(0);
        System.out.println("Bank removed credit from user: " + account.getUser());
    }
    public void printCredit(BankAccount account) {
        System.out.println("User: " + account.getUser() + " has credit: " + account.getCredit() + "$");
    }
    public void printAllCredits() {
        for (BankAccount account : accounts) {
            System.out.println("User: " + account.getUser() + " has credit: " + account.getCredit() + "$");
        }
    }
    public void addProcentCredit (BankAccount account){
        double procent = 0.05;
        double setProcent = 0;
        setProcent = account.getCredit() * procent;
        account.setCredit(account.getCredit() + setProcent);
        System.out.println("Bank added 5% to user: " + account.getUser());
    }
    public void addBonus (BankAccount account , int bonus){
        account.setMoney(account.getMoney() + bonus);
        System.out.println("Bank added " + bonus + "$ to user: " + account.getUser());
    }
    public  void checkUserTransaction(BankAccount account){
        account.printTransaction();
    }

}
