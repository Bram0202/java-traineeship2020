package labs.h7;

import java.math.BigDecimal;

public class BankAccount {
    private AccountNumber accountNumber;
    private String nameAccountHolder;
    private BigDecimal balance;
    static final double MIN_BALANCE = 0.0d;
    private double interestRate;

    BankAccount(AccountNumber accountNumber, String nameAccountHolder) {
        this(accountNumber, nameAccountHolder, BigDecimal.valueOf(0.0));
    }

    BankAccount(AccountNumber accountNumber, String nameAccountHolder, BigDecimal balance) {
        this(accountNumber, nameAccountHolder, balance, -0.5d);
    }

    BankAccount(AccountNumber accountNumber, String nameAccountHolder, double interestRate) {
        this(accountNumber, nameAccountHolder, BigDecimal.valueOf(0.0), -0.5d);
    }

    BankAccount(AccountNumber accountNumber, String nameAccountHolder, BigDecimal balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.nameAccountHolder = nameAccountHolder;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getAccountNumber() {
        String iban = accountNumber.getLandcode() + accountNumber.getControleCijfers() + accountNumber.getBankCode() + accountNumber.getRekeningIdentificatieNummer();
        return iban;
    }

    public String getNameAccountHolder() {
        return nameAccountHolder;
    }

    public void setNameAccountHolder(String nameAccountHolder) {
        this.nameAccountHolder = nameAccountHolder;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void withdrawMoney(double amount) {
        if (balance.subtract(BigDecimal.valueOf(amount)).compareTo(BigDecimal.ZERO) < MIN_BALANCE) {
            throw new IllegalArgumentException("Balance to low!");
        }
        this.balance = this.balance.subtract(BigDecimal.valueOf(amount));
    }

    public void depositMoney(double amount) {
        this.balance = this.balance.add(BigDecimal.valueOf(amount));
    }

    public BigDecimal calculateInterest() {
        return BigDecimal.ZERO;
    }

}
