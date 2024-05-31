import java.util.ArrayList;

public class BankAccount {
    private String user;
    private int money;
    private int indexUser;
    private double credit;
    private static final double DEFAULT_CREDIT_LIMIT = 0;
    private static final double DEFAULT_DEPOSIT_LIMIT = 0;
    ArrayList<TransactionBankPerson> transactionBankPerson = new ArrayList<>();
    private double depositBalance;

    public BankAccount(String user, int indexUser, int money, double credit, double depositCredit) {
        this.user = user;
        this.indexUser = indexUser;
        this.money = money;
        this.credit = DEFAULT_CREDIT_LIMIT;
        this.transactionBankPerson = new ArrayList<>();
        this.depositBalance = DEFAULT_DEPOSIT_LIMIT;
    }

    public ArrayList<TransactionBankPerson> getTransactionBankPerson() {
        return transactionBankPerson;
    }

    public void setTransactionBankPerson(ArrayList<TransactionBankPerson> transactionBankPerson) {
        this.transactionBankPerson = transactionBankPerson;
    }

    public double getDepositBalance() {
        return depositBalance;
    }

    public void setDepositBalance(double depositBalance) {
        this.depositBalance = depositBalance;
    }

    public ArrayList<TransactionBankPerson> getTransactionBank() {
        return transactionBankPerson;
    }

    public void setTransactionBank(ArrayList<TransactionBankPerson> transactionBankPerson) {
        this.transactionBankPerson = transactionBankPerson;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getIndexUser() {
        return indexUser;
    }

    public void setIndexUser(int indexUser) {
        this.indexUser = indexUser;
    }

    public void addTransaction(String type, int amount) {
        String date = java.time.LocalDate.now().toString();
        TransactionBankPerson transactionBankPerson = new TransactionBankPerson(type, amount, date);
        this.transactionBankPerson.add(transactionBankPerson);
    }

    public void printTransaction() {
        System.out.println("------------------------------------");
        System.out.println("Transaction history for " + user + ":");
        for (TransactionBankPerson transactionBankPerson : this.transactionBankPerson) {
            System.out.println(transactionBankPerson);
        }
    }

    public void printMyStatic() {
        System.out.println("------");
        System.out.println("User: " + getUser() + "\n" + "Balance: " + getMoney() + "$" + "\n" + "Credit: " + getCredit() + "$" + "\n" + "Deposit: " + getDepositBalance() + "$");
        System.out.println("------");
    }

    public void addMoney(int money, Bank bank) {
        if (money < 0) {
            System.out.println("You can't add a negative number");
            return;
        }
        double commission = money * 0.03;
        this.setMoney(this.getMoney() + money - (int) commission);
        bank.setMoneyBank(bank.getMoneyBank() + commission);
        System.out.println(this.getUser() + " you added " + money + "$ to your account");
        System.out.println(this.getUser() + " your balance is " + this.getMoney() + "$");
        this.addTransaction("add", money);
    }

    public void withdrawMoney(int money, Bank bank) {
        if (money > 0 && money <= this.getMoney()) {
            double commission = money * 0.03;
            this.setMoney(this.getMoney() - money - (int) commission);
            bank.setMoneyBank(bank.getMoneyBank() + commission);
            System.out.println(this.getUser() + " you withdrew " + money + "$ from your account");
            System.out.println(this.getUser() + " your balance is " + this.getMoney() + "$");
        } else {
            System.out.println(this.getUser() + " you don't have enough money");
        }
        this.addTransaction("withdraw", money);
    }

    public void remainderMoney() {
        System.out.println(this.getUser() + " your balance is " + this.getMoney() + "$");
        System.out.println(this.getUser() + " your index is " + this.getIndexUser());
    }

    public void transferMoney(BankAccount bankAccount, int money, Bank bank) {
        if (money > 0 && money <= this.getMoney()) {
            double commission = money * 0.03;
            this.setMoney(this.getMoney() - money - (int) commission);
            bankAccount.setMoney(bankAccount.getMoney() + money);
            bank.setMoneyBank(bank.getMoneyBank() + commission);
            System.out.println(this.getUser() + " you transferred " + money + "$ to Id Account " + bankAccount.getIndexUser() + "; User: " + bankAccount.getUser());
            System.out.println(this.getUser() + " your balance is " + this.getMoney() + "$");
        } else {
            System.out.println(this.getUser() + " you don't have enough money");
            return;
        }
        this.addTransaction("transfer", money);
    }

    public void closeCredit(int moneyClose) {
        double remainder = 0;

        if (getCredit() == 0) {
            System.out.println(this.getUser() + " your credit is already closed");
            return;
        }

        if (moneyClose > getMoney()) {
            System.out.println(this.getUser() + " You don't have enough money");
        } else {
            setMoney(getMoney() - moneyClose);
            if (moneyClose >= getCredit()) {
                remainder = moneyClose - getCredit();
                setCredit(0);
                setMoney((int) (getMoney() + remainder));
                System.out.println("You paid off your credit and the remainder has been added to your account");
            } else {
                setCredit(getCredit() - moneyClose);
            }
            System.out.println(this.getUser() + " your new balance is " + getMoney() + "$ and your remaining credit is " + getCredit() + "$");
        }
        this.addTransaction("closeCredit", moneyClose);
    }

    public void printCredit() {
        System.out.println(this.getUser() + " your credit is " + this.getCredit() + "$");
    }

    public void getCredit(int valumeCredit) {
        double addProcent = 0.05;
        double amountCredited = valumeCredit * (1 - addProcent);
        setCredit(getCredit() + valumeCredit);
        setMoney((int) (getMoney() + amountCredited));
        System.out.println(getUser() + " You added a credit of " + valumeCredit + "$ to your account");
        System.out.println(getUser() + " Your new balance is " + getMoney() + "$ and your credit is " + getCredit() + "$");
        this.addTransaction("getCredit", valumeCredit);
    }

    public void createDeposit(int depositBalance) {
        if (depositBalance < 0) {
            System.out.println("You can't add a negative number");
            return;
        }
        if (depositBalance > getMoney()) {
            System.out.println("You don't have enough money");
            return;
        }
        setMoney(getMoney() - depositBalance);
        setDepositBalance(getDepositBalance() + depositBalance);
        System.out.println(this.getUser() + " you added " + depositBalance + "$ to your deposit");
        System.out.println(this.getUser() + " your new deposit balance is " + getDepositBalance() + "$");
        this.addTransaction("createDeposit", depositBalance);
    }

    public void printDeposit() {
        System.out.println(this.getUser() + " your deposit balance is " + this.getDepositBalance() + "$");
    }

    public void closeDeposit() {
        double procent = 0.1;
        double setProcent = getDepositBalance() * procent;
        setDepositBalance(getDepositBalance() - setProcent);
        setMoney((int) (getMoney() + getDepositBalance()));
        setDepositBalance(0);
        System.out.println(this.getUser() + " closed deposit eartly time");
        System.out.println(this.getUser() + " your new balance is " + getMoney() + "$");
        this.addTransaction("User closed deposit early time", 0);
    }


}
