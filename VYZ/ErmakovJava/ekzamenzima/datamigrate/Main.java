package VYZ.ErmakovJava.ekzamenzima.datamigrate;

import VYZ.ErmakovJava.ekzamenzima.datamigrate.client.DataPool;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.dto.AccountDTO;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.AccountParser;

public class Main {
    
    public static void main(String[] args) {
        DataPool<AccountDTO> dataPool = new DataPool<>();
        dataPool.start(new AccountParser());
    }
}
