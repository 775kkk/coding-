package VYZ.ErmakovJava.kyrs2sem1.streambeta;

@FunctionalInterface
    public interface ApplyTripleBeta<A, B, R> {// java.util.function.BiFunction<A, B, R>

        R apply(A a, B b);

        // ApplyTripleBeta<Integer, Integer, Integer> sum = new ApplyTripleBeta<>() {
        //     @Override
        //     public Integer apply(Integer a, Integer b) {
        //         return a + b;
        //     }
        // };
        // ApplyTripleBeta<Integer, Integer, Integer> sum = (a, b) -> a + b;

    }
