package VYZ.ErmakovJava.kyrs2sem1.pract3;

public class IllegalGradeException extends RuntimeException {
    public IllegalGradeException(String message) {
        super(message);
    }

    public IllegalGradeException(String message, Throwable cause) {
        super(message, cause);
    }
}
