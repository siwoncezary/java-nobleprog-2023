package pl.nobleprog.advanced.day3.c3innerclasses;

public class Chicken {
    private int eggCounter = 0;
    private String dna;

    public Egg getEgg(){
        Egg egg = new Egg();
        egg.dna = this.dna;     // outer class hav access to all instance members of inner class!
        return egg;
    }

    public class Egg{
        private String dna;
        public Egg() {
            eggCounter++;       // inner class have access to all instance member of outer class!
        }
    }
}
