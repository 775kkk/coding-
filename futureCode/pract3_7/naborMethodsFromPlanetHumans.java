package futureCode.pract3_7;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import futureCode.pract3_6.reapText;

public class naborMethodsFromPlanetHumans {
    private static LocalDateTime curDatTime = LocalDateTime.now();
    private static String whatissun(LocalDateTime a){// номер 1
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("HH");
        int b = Integer.parseInt(a.format(formatDate));
        // я хотел както в short перетащить это все тк тип эффективнее будет
        // но без int вообще както не сообразил как сразу short сделать
        if ((23<b)||(b<6)) {
            return "Ночь";
        }
        if ((b>6)&&(10>b)) {
            return "Утро";
        }
        if ((b>10)&&(b<17)){
            return "День";
        }
        if ((b>17)&&(b<23)) {
            return "Вечер";
        }else{
            return "Ошибка";//хотел через try-catch но не сообразил как д и оно по сути заменялось одним елсе
        }
    }
    private static String whatisSunInspase(LocalDateTime a){// номер 2
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("MM");
        int b = Integer.parseInt(a.format(formatDate));
        if ((b>5)&&(b<9)) {
            return "Лето";
        }
        if ((b>11)||(b<3)) {
            return "Зима";
        }
        if ((b>2)&&(b<6)) {
            return "Весна";
        }
        if ((b<12)&&(b>8)) {
            return "Осень";
        }else{return "Ошибка";}
    }
    private static boolean weekend(LocalDateTime a){// номер 3
        DayOfWeek dayweek = a.getDayOfWeek();
        // int b = dayweek.getValue();
        if (dayweek.getValue()>5) {
            return true;
        }else{
            return false;
        }
    }
    private static boolean workday(LocalDateTime a){// номер 4
        return !(weekend(a));
    }

    public static void main(String[] args) {
        System.out.println(whatissun(curDatTime));// Номер 1
        System.out.println(whatisSunInspase(curDatTime));// Номер 2
        System.out.println(weekend(curDatTime));// Номер 3
        System.err.println(workday(curDatTime));// Номер 4
    }


}
