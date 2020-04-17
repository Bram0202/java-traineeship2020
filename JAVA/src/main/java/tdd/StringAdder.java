package tdd;

public class StringAdder {

    public int add(String... args) {
        int sum = 0;

        for (String arg : args) {
            arg = arg.replaceAll("\\s", "");
            arg = arg.replaceAll(";", "");

//            if (arg == null) {
//                sum += 0;
//
//               // throw new NullPointerException("Input kan geen null zijn!");
//            } else if (arg.isEmpty()) {
//                sum += 0;
//            } else if (arg.length() >= 1) {
//                sum += Integer.parseInt(arg);
//            } else {
//                throw new NumberFormatException("Invalid Input!");
//            }

            if (arg.length() >= 1) {
                sum += Integer.parseInt(arg);
            } else if (arg.length() <= 0) {
                sum += 0;
            } else {
                throw new NumberFormatException("Invalid Input!");
            }
        }
        return sum;
    }
}

// input = input.replaceAll("\\s", "");
