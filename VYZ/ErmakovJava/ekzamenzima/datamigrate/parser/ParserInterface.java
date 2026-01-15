package VYZ.ErmakovJava.ekzamenzima.datamigrate.parser;

import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.exception.ParseException;

public interface ParserInterface<T> {
    public T parse(String line) throws ParseException;
}
