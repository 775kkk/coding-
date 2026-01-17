package VYZ.ErmakovJava.ekzamenzima.byrocratiya.dto;

import java.util.List;

public record BlankZayavlenie(String Name, String Text, List<String> podpisy, boolean isNotApproved) {
}
