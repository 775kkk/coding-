import java.util.Objects;

abstract class Creature {
    protected String name;
    protected State state;

    public Creature(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public abstract void changeState(State newState);

    public String getName() {
        return name;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return name + " [" + state + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return Objects.equals(name, creature.name) && state == creature.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, state);
    }
}
