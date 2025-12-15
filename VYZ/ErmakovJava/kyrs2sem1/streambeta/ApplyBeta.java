package VYZ.ErmakovJava.kyrs2sem1.streambeta;

@FunctionalInterface
    public interface ApplyBeta<T, R> {// java.util.function.Function<T, R>
        R apply(T value);
        //  ApplyBeta<String, Integer> parseLen = new ApplyBeta<>() {
        //      @Override
        //      public Integer apply(String value) {
        //          // например, возвращаем длину строки
        //          return value.length();
        //      }
        //  };
        // ApplyBeta<String, Integer> parseLen = value -> value.length();
    }
