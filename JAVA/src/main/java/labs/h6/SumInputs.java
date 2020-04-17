package labs.h6;

import java.util.Scanner;

public class SumInputs {

    public static void main(String[] args) {
        new SumInputs();
    }

    SumInputs() {
//        int[] userInputsArr = userInput(3);
//        System.out.println("De som van de getallen is " + sumOfInput(userInputsArr));
    }

    // Opdracht 1
    int sumOfInput(int[] userInputsArr) {
        int sum = 0;

        for (int i : userInputsArr) {
            sum += i;
        }
        return sum;
    }

    // Ontvang user input (int) en geef deze terug als een int[].
    int[] userInput(int aantalInputs) {
        Scanner s = new Scanner(System.in);
        int[] inputsArr = new int[aantalInputs];

        System.out.println("Voer " + aantalInputs + " getallen in..");
        for (int i = 0; i < inputsArr.length; i++) {
            System.out.print("Getal " + (1 + i) + ": ");
            inputsArr[i] = s.nextInt();
        }

        return inputsArr;
    }
}



