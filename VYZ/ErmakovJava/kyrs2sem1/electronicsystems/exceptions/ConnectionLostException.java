package VYZ.ErmakovJava.kyrs2sem1.electronicsystems.exceptions;

public class ConnectionLostException extends Exception {

    public ConnectionLostException() {
        super();
    }

    public ConnectionLostException(String message) {
        super(message);
    }

    public ConnectionLostException(Throwable cause) {
        super(cause);
    }

    public ConnectionLostException(String message, Throwable cause) {
        super(message, cause);
    }
}

