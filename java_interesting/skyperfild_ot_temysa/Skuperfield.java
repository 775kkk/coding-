import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Skuperfield extends Creature implements Behavior {
    public Skuperfield() {
        super("Skuperfield", State.CALM);
    }
    private final Random random = new Random();

    @Override
    public void changeState(State newState) {
        this.state = newState;
    }

    @Override
    public void act() {
        if (state == State.BITTEN) {
            System.out.println("Чувствуя себя не в силах расправиться с ничтожным насекомым, "
                    + name + " пришел в бешенство.");
            changeState(State.ANGRY);
        }
    }
    public void observeShorties(List<Shorty> shorties) {
        System.out.println("Скуперфильд поднял голову и увидел вдали трех коротышек");

        // Скуперфильд пытается узнать одного из коротышек
        Optional<Shorty> recognized = tryToRecognize(shorties);
        recognized.ifPresentOrElse(
                shorty -> {
                    System.out.println("Один из них показался ему похожим на " + shorty.getName() + ".");
                    shorty.hide();
                },
                () -> System.out.println("Но Скуперфильд никого не узнал.")
        );
        if (random.nextInt(100) < 20) { // 20% шанс, что все спрячутся
            System.out.println("При виде Скуперфильда все коротышки испугались и спрятались!");
            shorties.forEach(Shorty::hide);
            return;
        }
    }

    private Optional<Shorty> tryToRecognize(List<Shorty> shorties) {
        Random random = new Random();
        return random.nextBoolean()
                ? Optional.of(shorties.get(random.nextInt(shorties.size())))
                : Optional.empty();
    }
}
