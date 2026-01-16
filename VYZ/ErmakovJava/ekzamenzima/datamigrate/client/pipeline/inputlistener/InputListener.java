package VYZ.ErmakovJava.ekzamenzima.datamigrate.client.pipeline.inputlistener;

public interface InputListener<T> {
    public T run();
    public void close();
    public boolean isClosed();
}
