public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount bankAccountAlex = bank.createAccount("Alex", 1, 100, 1);
        BankAccount bankAccountDron = bank.createAccount("Dron", 2, 200, 1);
        BankAccount bankAccountIlya = bank.createAccount("Ilya", 3, 300, 1);
        BankAccount bankAccountNikita = bank.createAccount("Nikita", 4, 400, 1);
        BankAccount bankAccountDanya = bank.createAccount("Danya", 5, 500, 1);
        System.out.println("----------------------------------");
        bankAccountAlex.addMoney(900);
        bankAccountAlex.transferMoney(bankAccountDron, 800);
        bankAccountAlex.withdrawMoney(200);
        System.out.println("----------------------------------");
        bankAccountDron.remainderMoney();
        bank.changeCredit(bankAccountDron, 200);
        bankAccountDron.closeCredit(200);
        bank.printStaticAccount(bankAccountDron);
        bankAccountDron.getCredit(1000);
        bank.printStaticAccount(bankAccountDron);
        bankAccountDron.addMoney(200);
        bankAccountDron.closeCredit(250);
        bankAccountDron.closeCredit(200);
        bankAccountDron.printCredit();
        System.out.println("----------------------------------");
        bank.addBonus(bankAccountIlya, 700);
        bank.printStaticAccount(bankAccountIlya);
        bank.changeCredit(bankAccountIlya, 600);
        bank.addProcentCredit(bankAccountIlya);
        bank.printStaticAccount(bankAccountIlya);
        bank.removeCredit(bankAccountIlya);
        bank.printStaticAccount(bankAccountIlya);
        bankAccountIlya.addMoney(2000);
        bankAccountIlya.transferMoney(bankAccountAlex, 1000);
        bank.checkUserTransaction(bankAccountAlex);
        bank.checkUserTransaction(bankAccountDron);
        bank.printAllAccounts();
        bank.printAllCredits();
        System.out.println("----------------------------------");
        //сделать новую функцию для депозитного счета 
    }
}