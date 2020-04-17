package labs.h10;

import java.util.ArrayList;

public class App{

    // Fields/
    ArrayList<Card> allCustomers = new ArrayList<Card>();


    // Main()
    public static void main(String[] args) throws ArgumentOutOfRangeException {
        new App();
    }


    // Constructor.
    App() {
        Card c = new RegularCard("Bram", "Straat 23", "Zuidwolde", 500.50d);
        allCustomers.add(c);

        Card c2 = new RegularCard("Mirthe", "Weg 5", "Amsterdam", 11.0d);
        allCustomers.add(c2);

        GoldCard c3 = new GoldCard("Johan", "Lana 19", "Groningen", 2340.50d);
        allCustomers.add(c3);

        printAllCustomers(Card.class);
        printAllCustomers(RegularCard.class);
        printAllCustomers(GoldCard.class);
        printAllCustomers(String.class);

        System.out.println(c.getCARD_ID());
        System.out.println(c2.getCARD_ID());
        System.out.println(c3.getCARD_ID());

        payment(c2.getCARD_ID(), 5);
        payment(c.getCARD_ID(), 5000);
        payment(c3.getCARD_ID(), 5000);

    }


    // Overige methoden.
    public void printAllCustomers(Class<?> cardType) {

        if (cardType.equals(Card.class)) {
            System.out.println("ALL CUSTOMERS");
            for (Card customer : allCustomers) {
                System.out.println(customer.getCARD_ID() + " (" + customer.getName() + ")");
            }
        } else if (cardType.equals(RegularCard.class)) {
            System.out.println("ALL REGULARCARDS");
            for (Card customer : allCustomers) {
                if (customer instanceof RegularCard) {
                    System.out.println(customer.getCARD_ID() + " (" + customer.getName() + ")");
                }
            }
        // Goldcard
        } else if (cardType.equals(GoldCard.class)) {
            System.out.println("ALL GOLDCARDS");
            for (Card customer : allCustomers) {
                if (customer instanceof GoldCard) {
                    System.out.println(customer.getCARD_ID() + " (" + customer.getName() + ")");
                }
            }
        } else {
            System.out.println("Geen resultaten gevonden!");
        }
        System.out.println("END\n");
    }


    void payment(int id, int amount) {
        for (Card customer : allCustomers) {
            if (customer.getCARD_ID() == id) {
                if (customer.pay(amount)) {
                    System.out.println("Betaling geslaagd!");
                } else if (!customer.pay(amount)) {
                    System.out.println("Te weinig saldo op deze kaart!");
                }
            }
        }
    }

}
