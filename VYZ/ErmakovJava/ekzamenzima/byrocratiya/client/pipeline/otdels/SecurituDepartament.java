package VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.otdels;

import java.util.List;

import VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.OtdelInterface;
import VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.PolicyInterface;
import VYZ.ErmakovJava.ekzamenzima.byrocratiya.dto.BlankZayavlenie;

public class SecurituDepartament implements OtdelInterface<BlankZayavlenie, PolicyInterface<BlankZayavlenie>> {
    @Override
    public BlankZayavlenie process(BlankZayavlenie input, PolicyInterface<BlankZayavlenie> policy) {
        if (!policy.checkPolicy(input)) {
            return new BlankZayavlenie(input.Name(),input.Text(),List.copyOf(input.podpisy()), true);
        }
        Podpisuat(input);
        return input;
    }
    public SecurituDepartament() {
    }
    public void Podpisuat(BlankZayavlenie dto){
        dto.podpisy().add(this.getClass().getSimpleName());
    }
    
}
