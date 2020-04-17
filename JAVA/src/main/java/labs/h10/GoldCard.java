package labs.h10;

public class GoldCard extends Card {

    // Fields.
    private int discount;


    // Constructor.
    GoldCard(String name, String address, String city, double credit) {
        super(name, address, city, credit);
    }


    // Overrides van static class Card.
    @Override
    boolean pay(int amount) {
        double amountMinusDiscount = amount - discount;

        if ( amountMinusDiscount <= credit) {
            credit -= amountMinusDiscount;
            return true;
        } else {
            return false;
        }
    }


    // Getters en Setters.
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) throws ArgumentOutOfRangeException {
        if (discount >= 1 && discount <= 30) {
            this.discount = discount;
            return;
        }

        throw new ArgumentOutOfRangeException("Discount moet binnen de range 1 - 30 liggen!");
    }

}
