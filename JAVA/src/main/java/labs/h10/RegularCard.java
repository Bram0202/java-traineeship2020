package labs.h10;

public class RegularCard extends Card {


    // Constructors.
    public RegularCard(String name, String address, String city, double credit) {
        super(name, address, city, credit);
    }


    // Overrides van static class Card.
    @Override
    boolean pay(int amount) {
        if ((double) amount <= credit) {
            credit -= amount;
            return true;
        } else {
            return false;
        }
    }

}
