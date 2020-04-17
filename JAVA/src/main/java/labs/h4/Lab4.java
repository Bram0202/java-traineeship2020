package labs.h4;

public class Lab4 {
    public static void main(String[] args) {
        new Lab4();
    }

    Lab4() {
        System.out.println(elevenProof(123456789));
//        System.out.println(elevenProof(123456788));

    }

    boolean elevenProof(int accountnumber) {
        int lengteVanAccountnumber = String.valueOf(accountnumber).length();
        int moduloWaarde = 1_000_000_000;
        int losCijfer;
        int som = 0;
        int positieInAccountnumber = lengteVanAccountnumber;

        while (positieInAccountnumber > 0) {
            losCijfer = accountnumber % moduloWaarde;
            // Blijft net zolang delen door 10, waardoor de andere cijfers kommagetallen worden en uit de int vallen.
            while (losCijfer > 9) {
                losCijfer /= 10;
            }

            // Bereken wat aan de som wordt toegevoegd, verlaag positie in inputgetal en verklaan de modulowaarde.
            som = som + (losCijfer * positieInAccountnumber);
            positieInAccountnumber--;
            moduloWaarde /= 10;
        }

        if (som % 11 == 0) {
            return true;
        } else {
            throw new IllegalArgumentException("Dit getal is geen valide getal!");
        }
    }
}
