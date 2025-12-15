package VYZ.ErmakovJava.kyrs2sem1.streambeta;

public class Main {
    public static void main(String[] args) {
        Integer numbers = Potok.of(1, 2, 3, 4, 5)
                                    .mapBeta(x -> x * x)
                                    .reduceBeta(0, Integer::sum);

        System.out.println(numbers);
        }
    }