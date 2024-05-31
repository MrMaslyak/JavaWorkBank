import java.util.ArrayList;

public class Bank {
    private boolean ban;
    private ArrayList<BankAccount> accounts;
    private double moneyBank;

    public Bank() {
        this.ban = false;
        this.accounts = new ArrayList<>();
        this.moneyBank = 0;
    }

    public double getMoneyBank() {
        return moneyBank;
    }

    public void setMoneyBank(double moneyBank) {
        this.moneyBank = moneyBank;
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

    public void checkMoneyBank() {
        System.out.println("Money in the bank: " + moneyBank);
    }

    public BankAccount createAccount(String user, int indexUser, int initialDeposit, double creditLimit, double depositBalance) {
        BankAccount newAccount = new BankAccount(user, indexUser, initialDeposit, creditLimit, depositBalance);
        accounts.add(newAccount);
        System.out.println("Bank created new account for user: " + user + " with initial deposit: " + initialDeposit + "$");
        return newAccount;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("We register your account in our Bank - " + account.getUser() + " with initial deposit: " + account.getMoney() + "$");
    }

    public void printAllAccounts() {
        System.out.println("-----------------------------------");
        System.out.println("All accounts in the bank:");
        for (BankAccount account : accounts) {
            System.out.println("Account: " + account.getUser() + ", Balance: " + account.getMoney() + "$, Index: " + account.getIndexUser());
        }
        System.out.println("-----------------------------------");
    }

    public void banAccount(BankAccount account) {
        this.accounts.remove(account);
        System.out.println("Account " + account.getUser() + " is banned");
    }

    public void unbanAccount(BankAccount account) {
        this.accounts.add(account);
        System.out.println("Account " + account.getUser() + " is unbanned");
    }

    public void printStaticAccount(BankAccount account) {
        System.out.println("------");
        System.out.println("User: " + account.getUser() + "\n" + "Balance: " + account.getMoney() + "$" + "\n" + "Credit: " + account.getCredit() + "$" + "\n" + "Deposit: " + account.getDepositBalance() + "$");
        System.out.println("------");
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

    public void printDeposit(BankAccount account) {
        System.out.println("User: " + account.getUser() + " has deposit: " + account.getDepositBalance() + "$");
    }

    public void printAllDeposits() {
        for (BankAccount account : accounts) {
            System.out.println("User: " + account.getUser() + " has deposit: " + account.getDepositBalance() + "$");
        }
    }

    public void addProcentCredit(BankAccount account) {
        double procent = 0.05;
        double setProcent = 0;
        setProcent = account.getCredit() * procent;
        account.setCredit(account.getCredit() + setProcent);
        System.out.println("Bank added 5% to user: " + account.getUser());
    }

    public void addBonus(BankAccount account, int bonus) {
        account.setMoney(account.getMoney() + bonus);
        System.out.println("Bank added " + bonus + "$ to user: " + account.getUser());
    }

    public void checkUserTransaction(BankAccount account) {
        account.printTransaction();
    }

    public void closeDeposit(BankAccount account) {
        account.setMoney((int) (account.getMoney() + account.getDepositBalance()));
        account.setDepositBalance(0);
        System.out.println("Bank close deposit from user: " + account.getUser());
        this.addTransaction("Bank close deposit", (int) account.getDepositBalance());
    }

    private void addTransaction(String bankCloseDeposit, int depositBalance) {
        // for add closeDeposit .addTransaction
    }

    public void addEarnings8ProcentDepositUser(BankAccount account) {
        if (account.getDepositBalance() > 0) {
            double procent = 0.08;
            double setProcent = account.getDepositBalance() * procent;
            account.setDepositBalance(account.getDepositBalance() + setProcent);
            account.addTransaction("Bank add 8% on deposit money", (int) setProcent);
            System.out.println(account.getUser() + " bank added 8% to his deposit");
        } else {
            System.out.println(account.getUser() + " you don't have deposit");
        }
    }

    public void addEarnings5ProcentDepositUser(BankAccount account) {
        if (account.getDepositBalance() > 0) {
            double procent = 0.05;
            double setProcent = account.getDepositBalance() * procent;
            account.setDepositBalance(account.getDepositBalance() + setProcent);
            account.addTransaction("Bank add 5% on deposit money", (int) setProcent);
            System.out.println(account.getUser() + " bank added 5% to his deposit");
        } else {
            System.out.println(account.getUser() + " you don't have deposit");
        }
    }

    public void addEarnings10ProcentDepositUser(BankAccount account) {
        if (account.getDepositBalance() > 0) {
            double procent = 0.10;
            double setProcent = account.getDepositBalance() * procent;
            account.setDepositBalance(account.getDepositBalance() + setProcent);
            account.addTransaction("Bank add 10% on deposit money", (int) setProcent);
            System.out.println(account.getUser() + " bank added 10% to his deposit");
        } else {
            System.out.println(account.getUser() + " you don't have deposit");
        }
    }

}
