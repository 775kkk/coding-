package VYZ.ErmakovJava.kyrs2sem1.streambeta;

@FunctionalInterface
    public interface GetTBeta<T> {// java.util.function.Supplier<T>

        T get();
        // GetTBeta<Double> random = new GetTBeta<>() {
        //     @Override
        //     public Double get() {
        //         return Math.random();
        //     }
        // };
        // GetTBeta<Double> random = () -> Math.random();
    }