package VYZ.ErmakovJava.kyrs2sem1.karate;

public class Karatist {
    private final String name; // неизменяемое

    public Karatist(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void kick() {
        System.out.println(name + " бац!");
    }

    public void punch() {
        System.out.println(name + " кия!");
    }

    public void jumpStrike() {
        System.out.println(name + " вжух!");
    }
}
