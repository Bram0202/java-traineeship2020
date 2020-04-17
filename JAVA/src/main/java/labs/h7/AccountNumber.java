package labs.h7;

public class AccountNumber {
    private String landcode;
    private String controleCijfers;
    private String bankCode;
    private String rekeningIdentificatieNummer;

    AccountNumber(String landcode, String controleCijfers, String bankCode, String rekeningIdentificatieNummer) {
        this.landcode = landcode;
        this.controleCijfers = controleCijfers;
        this.bankCode = bankCode;
        this.rekeningIdentificatieNummer = rekeningIdentificatieNummer;
    }

    public String getLandcode() {
        return landcode;
    }

    public String getControleCijfers() {
        return controleCijfers;
    }

    public String getBankCode() {
        return bankCode;
    }

    public String getRekeningIdentificatieNummer() {
        return rekeningIdentificatieNummer;
    }
}
