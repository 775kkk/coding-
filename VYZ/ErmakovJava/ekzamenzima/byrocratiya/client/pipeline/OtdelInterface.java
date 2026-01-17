package VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline;


public interface OtdelInterface<DTO, Policy extends PolicyInterface<DTO>> {
    public DTO process(DTO input, Policy policy);
    public void Podpisuat(DTO dto);
}
