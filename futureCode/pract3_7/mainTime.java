package futureCode.pract3_7;

import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Period;

import java.time.LocalTime;

public class mainTime {
    public static void main(String[] args) {
    LocalDate curDat = LocalDate.now();
    System.out.println("текущ дат  "+ curDat);
    
    LocalDateTime curDatTime = LocalDateTime.now();
    System.out.println("тек дат и время  "+curDatTime);

    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    System.out.println("Текущая дата в формате dd.MM.yyyy  "+ formatDate);


    LocalDate starDate = LocalDate.of(2024,1,1);
    LocalDate nowDate = LocalDate.of(2024,3,17);
    
    Period period = Period.between(starDate, nowDate);
    System.out.println(" меж "+starDate+ " и "+ nowDate + " прошло "+period.getYears()+" лет "+period.getMonths()+" месяца "+period.getDays()+" дней");


    LocalTime nowTime = LocalTime.now();
    DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH.mm.ss");
        String formatedTimenow = nowTime.format(formatTime);
        System.out.println(formatedTimenow);

    }
}
