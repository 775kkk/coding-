package VYZ.ErmakovJava.ekzamenzima.datamigrate.parser;

import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.exception.ParseException;

public interface ParserInterface<T,S> {
    public T parse(S item) throws ParseException;
}
