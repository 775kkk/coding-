package VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.policy;

import java.util.List;

import VYZ.ErmakovJava.ekzamenzima.byrocratiya.client.pipeline.PolicyInterface;
import VYZ.ErmakovJava.ekzamenzima.byrocratiya.dto.BlankZayavlenie;

public class SecurituDepartamentPolicy implements PolicyInterface<BlankZayavlenie> {
    @Override
    public boolean checkPolicy(BlankZayavlenie dto) {
        //гетаем лист
        List<String> blockedUsers = List.of("zzzz", "1111");
        for (String blockedUser : blockedUsers) {
            if (dto.Name().equalsIgnoreCase(blockedUser)) {
                System.out.println("User " + dto.Name() + " is blocked by Security Department.");
                return false;
            }
        }
        return true;
    }
    
}
