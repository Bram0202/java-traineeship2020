package labs.h7;

import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        Bank rabo = new Bank("Rabobank", "RABO", "NL");
        Database db = new Database(rabo); // Init de account voor een demo bank.

        rabo.printAllAccountsbalanceInfo();

        rabo.transfer(rabo.getBankAccount("DiGiovanniN"), rabo.getBankAccount("BakxB"), 1000);
        rabo.transfer(rabo.getBankAccount("BakxB"), rabo.getBankAccount("KromB"), 30);
        rabo.transfer(rabo.getBankAccount("KromB"), rabo.getBankAccount("JanssensB"), 37.84);
        rabo.transfer(rabo.getBankAccount("BakxB"), rabo.getBankAccount("JanssensB"), 5.27);

        //rabo.printAllAccountsbalanceInfo();
        rabo.printSumOfAllAcountsBalances();
        rabo.printAllAccountsInfo();

    }
}
