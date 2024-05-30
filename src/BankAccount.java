import java.util.ArrayList;

public class BankAccount {
    private String user;
    private int money;
    private int indexUser;
     private double credit;
    private static final double DEFAULT_CREDIT_LIMIT = 0;
    ArrayList <TransactionBankPerson> transactionBankPerson = new ArrayList<>();

    public BankAccount(String user, int indexUser, int money , double  credit) {
        this.user = user;
        this.indexUser = indexUser;
        this.money = money;
        this.credit = DEFAULT_CREDIT_LIMIT;
        this.transactionBankPerson = new ArrayList<>();
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
public void  addTransaction(String type, int amount){
      String date = java.time.LocalDate.now().toString();
      TransactionBankPerson transactionBankPerson = new TransactionBankPerson(type, amount, date);
      this.transactionBankPerson.add(transactionBankPerson);
}
public void printTransaction(){
    System.out.println("------------------------------------");
    System.out.println("Transaction history for " + user + ":");
        for (TransactionBankPerson transactionBankPerson : this.transactionBankPerson) {
            System.out.println(transactionBankPerson);
        }
}
    public void addMoney(int money){
        if (money < 0) {
            System.out.println("You can't add a negative number");
            return;
        }
        this.setMoney(this.getMoney() + money);
        System.out.println(this.getUser() + " you added " + money + "$ to your account");
        System.out.println(this.getUser() + " your balance is " + this.getMoney() + "$");
        this.addTransaction("add", money);
    }

    public void withdrawMoney(int money){
        if (money > 0 && money <= this.getMoney()) {
            this.setMoney(this.getMoney() - money);
            System.out.println(this.getUser() + " you withdrew " + money + "$ from your account");
            System.out.println(this.getUser() + " your balance is " + this.getMoney() + "$");
        } else {
            System.out.println(this.getUser() + " you don't have enough money");
        }
        this.addTransaction("withdraw", money);
    }

    public void remainderMoney(){
        System.out.println(this.getUser() + " your balance is " + this.getMoney() + "$");
        System.out.println(this.getUser() + " your index is " + this.getIndexUser());
    }

    public void transferMoney(BankAccount bankAccount, int money){
        if (money > 0 && money <= this.getMoney()) {
            this.setMoney(this.getMoney() - money);
            bankAccount.setMoney(bankAccount.getMoney() + money);
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
    public void printCredit(){
        System.out.println(this.getUser() + " your credit is " + this.getCredit() + "$");
    }
    public void getCredit(int valumeCredit) {
        double addProcent = 0.05;
        double amountCredited = valumeCredit * (1 - addProcent); // Удержание 5% от суммы кредита
        setCredit(getCredit() + valumeCredit); // Добавляем всю сумму кредита к текущему кредитному балансу
        setMoney((int) (getMoney() + amountCredited)); // Добавляем сумму с учетом удержания на баланс пользователя
        System.out.println(getUser() + " You added a credit of " + valumeCredit + "$ to your account");
        System.out.println(getUser() + " Your new balance is " + getMoney() + "$ and your credit is " + getCredit() + "$");
        this.addTransaction("getCredit", valumeCredit);
    }


}
