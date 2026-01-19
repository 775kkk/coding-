package exceptions;

public class ParentsException extends Exception {
    public ParentsException(){
        super();
    }
    public ParentsException(String m){
        super(m);
    }
    public ParentsException(Throwable throwable){
        super(throwable);
    }
    public ParentsException(String m, Throwable throwable){
        super(m,throwable);
    }
}
