public class Shorty extends Creature implements Behavior {
    public Shorty(String name) {
        super(name, State.HIDDEN);
    }

    @Override
    public void changeState(State newState) {
        this.state = newState;
    }

    @Override
    public void act() {
        switch (state) {
            case HIDDEN -> System.out.println(name + " скрылся за деревом.");
            case CALM -> System.out.println(name + " медленно подходит к Скуперфильду.");
        }
    }
    public void hide() {
        if (state == State.VISIBLE) {
            state = State.HIDDEN;
            System.out.println(name + " скрылся за деревом.");
        }
    }

}

