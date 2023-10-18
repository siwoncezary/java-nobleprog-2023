package pl.nobleprog.advanced.day3.c3innerclasses;

public class Chicken {
    private String dna;
    private int eggCounter;

    public Egg getEgg(){
        var egg =new Egg();
        egg.dna  = dna;
        return egg;
    }
    public class Egg{
        private String dna;
        public Egg(){
            eggCounter++;
        }
    }

    public int getEggCounter() {
        return eggCounter;
    }
}
