import java.util.*;
public class story {
    public static void main(String[] args) {
        // Создаем Скуперфильда
        Skuperfield skuperfield = new Skuperfield();

        // Создаем коротышек
        List<Shorty> shorties = new ArrayList<>();
        shorties.add(new Shorty("Krabs"));
        shorties.add(new Shorty("Miga"));
        shorties.add(new Shorty("Julio"));

        // Генерация случайного состояния коротышек
        Random random = new Random();


        // Создаем насекомое
        Bug bug = new Bug("Flea");

        // Симуляция
        try {
            // Кусает ли клоп Скуперфильда
            if (random.nextBoolean()) {
                bug.bite(skuperfield);
                skuperfield.act();
            } else {
                throw new BugException();
            }
        } catch (BugException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Forest.makeSoundAndRevealShorties(shorties);
        skuperfield.observeShorties(shorties);
        shorties.forEach(Shorty::act);







        // Проверка на нестандартное состояние
        if (shorties.stream().allMatch(shorty -> shorty.getState() == State.HIDDEN)) {
            throw new EnvironmentException("Все коротышки спрятались. Сценарий завершен неожиданно!");
        }
    }
}

