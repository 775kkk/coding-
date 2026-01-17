package VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.otdels;

import VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.OtdelInterface;
import VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.PolicyInterface;
import VYZ.ErmakovJava.ekzamenzima.byrocratiya.dto.BlankZayavlenie;

public class AccountingDepartament implements OtdelInterface<BlankZayavlenie, PolicyInterface<BlankZayavlenie>> {
    @Override
    public BlankZayavlenie process(BlankZayavlenie input, PolicyInterface<BlankZayavlenie> policy) {
        if (!policy.checkPolicy(input)) {
            return new BlankZayavlenie(input.Name(),input.Text(),input.podpisy(), true);
        }
        OtdelCadrov.process(input, policy);
        Podpisuat(input);
        return input;
    }
    public AccountingDepartament() {
    }
    public void Podpisuat(BlankZayavlenie dto){
        dto.podpisy().add(this.getClass().getSimpleName());
    }

}