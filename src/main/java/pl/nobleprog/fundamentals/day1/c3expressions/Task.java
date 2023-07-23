package pl.nobleprog.fundamentals.day1.c3expressions;

public class Task {
    public static void main(String[] args) {
        if (lastDigit((byte)124) == 4 && lastDigit((byte) 19) == 9 && lastDigit((byte) -122) == 2){
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }

        if (sumOfDigits(123.890) == 6 && sumOfDigits(-25.0234) == 7){
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }

        if (isInRange(5, 3, 5) && !isInRange(5, 6, 9)){
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }
        if (mostSignificantByte(0x23112244) == (byte) 0x23 && mostSignificantByte(0xFF001100) == (byte) 0xFF){
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAIL");
        }
    }


    public static int sumOfDigits(double n){
        int a = 0;
        // zadanie 1
        // poniżej zapisz wyrażenie, które przypisze do zmiennej a sumę cyfr setek, dziesiątek i jedności liczby n

        return a;
    }

    public static int lastDigit(byte n){
        int a = 0;
        // zadanie 2
        // poniżej zapisz wyrażenie, które przypisze do zmiennej a ostanią cyfrę liczby n

        return a;
    }

    public static boolean isInRange(int a, int min, int max){
        boolean result = false;
        // zadanie 3
        // poniżej zapisz wyrażenie logiczne przypisujące prawdę zmiennej result, jeśli a jest mniejsze lub równe od min i mniejsze, lub równe max

        return result;
    }

    public static byte mostSignificantByte(int word){
        byte last = 0;
        // zadanie 4
        // poniżej zapisz wyrażenie przypisujące zmiennej last wartość najbardziej znaczącego bajtu parametru word

        return last;
    }
}
