package VYZ.ErmakovJava.kyrs2sem1.pract3;

public class IllegalGradeException extends RuntimeException {

    public IllegalGradeException() {
        super();
    }

    public IllegalGradeException(String message) {
        super(message);
    }

    public IllegalGradeException(Throwable cause) {
        super(cause);
    }
    public IllegalGradeException(String message, Throwable cause) {
        super(message, cause);
    }
    // -->
    // catch (Exception e) {
    //     throw new MyDomainException("Контекст", e);
    // }
    // -->
    // IllegalGradeException: invalid grade
    //    caused by NumberFormatException: For input string: "abc"
//  цепи

}
