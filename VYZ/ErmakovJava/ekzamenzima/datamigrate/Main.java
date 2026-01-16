package VYZ.ErmakovJava.ekzamenzima.datamigrate;

import VYZ.ErmakovJava.ekzamenzima.datamigrate.client.DataPool;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.client.pipeline.inputlistener.CmdListener;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.dto.AccountDTO;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.AccountParser;

public class Main {
    
    public static void main(String[] args) {
        DataPool<AccountDTO, String> dataPool = new DataPool<>();
        
        dataPool.addProcedure(account -> {
            System.out.println("Processed account: " + account);
            return account;
        });
        dataPool.start(new CmdListener(), new AccountParser());
    }
}
