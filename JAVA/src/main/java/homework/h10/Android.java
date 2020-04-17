package homework.h10;

public class Android extends Human implements Chargeable {
    
    private int level = 43;
    private final int maxLevel = 100;

    // Override van abstract class Human.
    @Override
    public String greet() {
        return "I'm only half human, but human still...\nMy energy level is " + level + "%";
    }

    // Override van interface Chargeable.
    @Override
    public int charge(int amount) {
        if ((level + amount) > maxLevel) {
            return level = 100;
        } else {
            return level += amount;
        }
    }

}
