package VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.exception;

public class ParseException extends Exception {
    public ParseException() {
        super();
    }
    public ParseException(String s) {
        super(s);
    }
    public ParseException(String s, Throwable cause) {
        super(s);
        initCause(cause);
    }
    public ParseException(Throwable cause) {
        super(cause.getMessage());
        initCause(cause);
    }
}
