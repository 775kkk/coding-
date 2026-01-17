package VYZ.ErmakovJava.ekzamenzima.byrocratiya.parcer;

public interface InputParcerInterface<DTO,INPUT> {
    public DTO parse(INPUT input);
    public void cancel();
}
