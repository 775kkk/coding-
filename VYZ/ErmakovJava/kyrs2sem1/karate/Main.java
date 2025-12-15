package VYZ.ErmakovJava.kyrs2sem1.karate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Karatist tailer = new Karatist("Тайлер");
        Karatist derden = new Karatist("Дерден");

        Combo combo = new Combo(tailer);
        combo.execute(new LegStrike(), new HandStrike(), new JumpStrike());
        Combo combo2 = new Combo(derden);
        combo2.execute(new HandStrike(), new JumpStrike(), new LegStrike());
    }
}
