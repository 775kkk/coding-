package VYZ.ErmakovJava.ekzamenzima.datamigrate.parser;

import VYZ.ErmakovJava.ekzamenzima.datamigrate.dto.AccountDTO;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.exception.IllegalStringToParseException;

public class AccountParser implements ParserInterface<AccountDTO,String> {
    @Override
    public AccountDTO parse(String line) throws IllegalStringToParseException {
        if (line.chars().filter(c -> c == ';').count() != 2) throw new IllegalStringToParseException("String to parse is incorrect");

        String[] parts = line.split(";");
        if (parts.length!=3) throw new IllegalStringToParseException("String to parse is too short");
        
        String[] names = parts[1].trim().split("\\s+");
        if (names.length!=2) throw new IllegalStringToParseException("Name part is incorrect");
        return new AccountDTO(
                Integer.parseInt(parts[0].trim()),
                names[0].trim(),
                names[1].trim(),
                parts[2].trim()
        );
    }
}
