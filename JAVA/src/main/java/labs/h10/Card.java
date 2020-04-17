package labs.h10;

public abstract class Card {

    // Fields.
    protected String name;
    protected String address;
    protected String city;
    protected double credit;
    protected final int CARD_ID;

    // Constructors
    Card(String name, String address, String city, double credit) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.credit = credit;

        CARD_ID = name.hashCode() * address.hashCode() * city.hashCode();
    }


    // Getters en Setters.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getCARD_ID() {
        return CARD_ID;
    }


    // Other methods.
    abstract boolean pay(int amount);

}
