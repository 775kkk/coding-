import java.util.List;

public class Forest {
    public static void makeSoundAndRevealShorties(List<Shorty> shorties) {
        System.out.println("В лесу послышались чьи-то шаги.");
        shorties.forEach(shorty -> shorty.changeState(State.VISIBLE));
    }
}
