package pl.nobleprog.fundamentals.day1.c4statements;

public class Task {
    public static void main(String[] args) {
        System.out.print("Task 1: ");
        if (temperatureStates(3).equals("freezing") && temperatureStates(15).equals("cold") && temperatureStates(16).equals("warm")) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }
        System.out.print("Task 2: ");
        if (triangle(3).equals("*\n**\n***".trim()) && triangle(1).equals("*".trim())) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }
        System.out.print("Task 3: ");
        if (romanToDecimal("I") == 1 && romanToDecimal("II") == 2 && romanToDecimal("III") == 3 && romanToDecimal("IV") == 4 && romanToDecimal("V") == 5 && romanToDecimal("GH") < 0) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static String temperatureStates(double temperature) {
        String state = "unknown";
        // przypisz do zmiennej state jeden z trzech łańcuchów:
        // jeśli temperature jest mniejsze od 5 - "freezing"
        // jeśli temperature jest większe lub równe 5 i mniejsze od 15 - "cold"
        // jeśli temperature jest większe od 15 - "warm"
        return state;
    }

    public static String triangle(int height) {
        String triangle = "";
        // Przypisz do zmiennej triangle łańcuch tworzący trójkąt o wysokości height
        // utworzony z gwiazdek
        // np. dla height = 4:
        // *
        // **
        // ***
        // ****
        // Wykorzystaj metodę:
        // "*".repeat(n)
        // do generowanie jednego wiersza gwiazdek.

        return triangle;
    }

    public static int romanToDecimal(String roman) {
        int number = 0;
        // Zastosuj switch, aby przypisać do zmiennej number
        // wartość dziesiętną liczby rzymskiej, która jest w parametrze roman.
        // Załóż, że w roman jest łańcuch reprezentujący liczby od I do V: I, II, III, IV, V
        // Dla każdego innego łańcucha przypisz do number liczbę -1
        return number;
    }
}
