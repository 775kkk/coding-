package VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline;
@FunctionalInterface
public interface PolicyInterface<DTO> {
    public boolean checkPolicy(DTO dto);
}
