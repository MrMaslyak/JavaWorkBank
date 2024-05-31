public class Main {
    public static void main(String[] args) {
        // Command Bank:
        // create commision on add , remove , transfer
        // createAccount
        // checkMoneyBank
        // addAccount
        // printAllAccounts
        // banAccount
        // unbanAccount
        // printStaticAccount
        // changeCredit
        // removeCredit
        // printCredit
        // printAllCredits
        // printDeposit
        // printAllDeposits
        // addProcentCredit
        // addBonus
        // checkUserTransaction
        // closeDeposit
        // addTransaction
        // addEarnings8ProcentDepositUser
        // addEarnings5ProcentDepositUser
        // addEarnings10ProcentDepositUser
        //
        // Command BankAccount:
        //
        // addTransaction
        // printTransaction
        // printMyStatic
        // addMoney
        // withdrawMoney
        // remainderMoney
        // transferMoney
        // closeCredit
        // printCredit
        // getCredit
        // createDeposit
        // printDeposit
        // closeDeposit
        //
        Bank bank = new Bank();
        BankAccount bankAccountAlex = bank.createAccount("Alex", 1, 100, 1, 1);
        BankAccount bankAccountDron = bank.createAccount("Dron", 2, 200, 1, 1);
        BankAccount bankAccountIlya = bank.createAccount("Ilya", 3, 300, 1, 1);
        BankAccount bankAccountNikita = bank.createAccount("Nikita", 4, 400, 1, 1);
        BankAccount bankAccountDanya = bank.createAccount("Danya", 5, 500, 1, 1);
        BankAccount bankAccountIgor = bank.createAccount("Igor", 6, 1500, 1, 1);

        System.out.println("----------------------------------");
        bankAccountAlex.addMoney(1000 , bank);
        bankAccountAlex.transferMoney(bankAccountDron, 1000, bank);
        bankAccountAlex.withdrawMoney(200, bank);
        System.out.println("----------------------------------");
        bankAccountDron.remainderMoney();
        bank.changeCredit(bankAccountDron, 200);
        bankAccountDron.closeCredit(200);
        bank.printStaticAccount(bankAccountDron);
        bankAccountDron.getCredit(1000);
        bank.printStaticAccount(bankAccountDron);
        bankAccountDron.addMoney(200 , bank);
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
        bankAccountIlya.addMoney(2000 , bank);
        bankAccountIlya.transferMoney(bankAccountAlex, 1000, bank);
        bank.checkUserTransaction(bankAccountAlex);
        bank.checkUserTransaction(bankAccountDron);
        bank.printAllAccounts();
        bank.printAllCredits();
        System.out.println("----------------------------------");
        bankAccountNikita.addMoney(100 , bank);
        bankAccountNikita.createDeposit(500);
        bank.addEarnings10ProcentDepositUser(bankAccountNikita);
        bankAccountNikita.printDeposit();
        bankAccountNikita.closeDeposit();
        bankAccountNikita.printMyStatic();
        System.out.println("----------------------------------");
        bank.checkMoneyBank();
    }


}