package pl.nobleprog.advanced.day1.c2interface.task;

public class ArrayHistory implements History{
    private String[] content = new String[5];
    private int last = -1;
    private int count = 0;
    @Override
    public void insert(String s) {
        last = content.length - 1 == last ? -1 : last;
        content[++last] = s;
        count++;
        count = Math.min(count, content.length);
    }

    @Override
    public String[] last(int n) {
        if (n < 0){
            throw new IllegalArgumentException("Liczba wpisów nie może być ujemna!");
        }
        if (n == 0){
            return new String[0];
        }
        if (n > count){
            n = count;
        }
        String[] result = new String[n];
        int i = last;
        int j = 0;
        while(n > 0){
            n--;
            if (i < 0){
                i = content.length - 1;
            }
            result[j++] = content[i--];
        }
        return result;
    }
}
