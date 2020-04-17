package homework.h13;

import homework.h10.Human;

public class House<H extends Human> {

    H value;

    public House(H value) {
        this.value = value;
    }

    public H getValue() {
        return value;
    }

    public void setValue(H value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "This house is owned by [" + getValue().toString() + "] and it says [" + getValue().greet() + "].";
    }

}

