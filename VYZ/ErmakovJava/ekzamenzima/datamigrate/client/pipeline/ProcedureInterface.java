package VYZ.ErmakovJava.ekzamenzima.datamigrate.client.pipeline;

@FunctionalInterface
public interface ProcedureInterface<T> {
    public T execute(T item);
}
