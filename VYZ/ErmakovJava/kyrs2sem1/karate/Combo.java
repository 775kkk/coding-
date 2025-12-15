package VYZ.ErmakovJava.kyrs2sem1.karate;

public class Combo {
    private final Karatist karatist;
    public Combo(Karatist karatist) {
        this.karatist = karatist;
    }
    public void execute(Strike... strikes) {
        for (Strike strike : strikes) {
            strike.execute(karatist);
        }
    }
}
