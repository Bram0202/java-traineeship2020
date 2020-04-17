package labs.h7;

import java.math.BigDecimal;

public class Database {

    Database(Bank bankName) {
        init(bankName);
    }

    void init(Bank bankName){
        bankName.addNewBankAccount( "BakxB", BigDecimal.valueOf(100_000), 3.5);
        bankName.addNewBankAccount("BouchardW", BigDecimal.valueOf(3_234.23), 3.5);
        bankName.addNewBankAccount( "VerheesJ", 3.5);
        bankName.addNewBankAccount("JanssensB", BigDecimal.valueOf(8_2342.87));
        bankName.addNewBankAccount( "KromB", BigDecimal.valueOf(345.45));
        bankName.addNewBankAccount( "DiGiovanniN");

        // Initial deposit. Als dat niet direct al gedaan is.
        bankName.getBankAccount("DiGiovanniN").depositMoney(6534.34);
    }
}

