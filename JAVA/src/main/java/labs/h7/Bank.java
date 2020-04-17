package labs.h7;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Random;

public class Bank {
    private String name;
    private String bankCode;
    private String landcode;
    private HashMap<String, BankAccount> bankAccounts = new HashMap<>();

    Bank(String name, String bankCode, String landcode) {
        this.name = name.toUpperCase();
        this.bankCode = bankCode.toUpperCase();
        this.landcode = landcode.toUpperCase();
    }

    public BankAccount getBankAccount(String nameAccountHolder) {
        return bankAccounts.get(nameAccountHolder);
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        try {
            from.withdrawMoney(amount);
            to.depositMoney(amount);
            System.out.println("Transfer succeed!\nTransferred €" + amount + " from " + from.getAccountNumber() + " (" + from.getNameAccountHolder() + ")" + " to " + to.getAccountNumber() + " (" + to.getNameAccountHolder() + ")\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Transfer Failed! " + e.getMessage());
        }
    }

    public void addNewBankAccount(String name) {
        bankAccounts.put(name, new BankAccount(createNewAccountNumber(bankCode, landcode), name));
    }

    public void addNewBankAccount(String name, BigDecimal balance) {
        bankAccounts.put(name, new BankAccount(createNewAccountNumber(bankCode, landcode), name, balance));
    }

    public void addNewBankAccount(String name, double interestRate) {
        bankAccounts.put(name, new BankAccount(createNewAccountNumber(bankCode, landcode), name, interestRate));
    }

    public void addNewBankAccount(String name, BigDecimal balance, double interestRate) {
        bankAccounts.put(name, new BankAccount(createNewAccountNumber(bankCode, landcode), name, balance, interestRate));
    }


    public void printAllAccountsbalanceInfo() {
        divider();
        divider();
        System.out.println("All account balances:");

        for (BankAccount i : bankAccounts.values()) {
            System.out.println("Owner: " + i.getNameAccountHolder());
            System.out.println("Balance: €" + i.getBalance());
            divider();
        }

        System.out.println("END");
        divider();
        divider();
    }

    public void printAllAccountsInfo() {
        divider();
        divider();
        System.out.println("All accounts info in this bank:");

        for (BankAccount i : bankAccounts.values()) {
            System.out.println("Owner: " + i.getNameAccountHolder());
            System.out.println("Account number: " + i.getAccountNumber());
            System.out.println("Balance: €" + i.getBalance());
            System.out.println("Interest rate: " + i.getInterestRate());
            divider();
        }

        System.out.println("END");
        divider();
        divider();
    }

    public void printSumOfAllAcountsBalances() {
        BigDecimal sum = BigDecimal.valueOf(0.0);

        for (BankAccount i : bankAccounts.values()) {
            sum = sum.add(i.getBalance());
        }

        // Printen.
        divider();
        divider();
        System.out.println("Sum of all balances:");
        System.out.println(name + "\nSum of all balances = €" + sum);
        System.out.println("END");
        divider();
        divider();
    }

    public void divider() {
        System.out.println("#####################################################################################");
    }

    public AccountNumber createNewAccountNumber(String bankCode, String landcode) {
        String controleCijfers = createNewNumberSequence(2);
        String rekeningIdentificatieNummer = createNewNumberSequence(10);

        return new AccountNumber(landcode, controleCijfers, bankCode, rekeningIdentificatieNummer);
    }

    // Maakt een nieuwe cijfer reeks (als String), o.a. voor IBAN.
    public String createNewNumberSequence(int length) {
        String numberSequence = (int) (Math.random() * Math.pow(10, length)) + "";

        if (numberSequence.length() < length) {
            numberSequence = "0" + numberSequence;
        }
        return numberSequence;
    }

}
