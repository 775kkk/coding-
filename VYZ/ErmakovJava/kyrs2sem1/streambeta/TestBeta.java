package VYZ.ErmakovJava.kyrs2sem1.streambeta;

public interface TestBeta<T>{// java.util.function.Predicate<T>
    boolean test(T value);
    //  TestBeta<String> notEmpty = new TestBeta<>() {
    //      @Override
    //      public boolean test(String value) {
    //          return value != null && !value.isEmpty();
    //      }
    //   };
    // TestBeta<String> notEmpty = value -> value != null && !value.isEmpty();
}
