package VYZ.ErmakovJava.ekzamenzima.datamigrate.client;

import java.util.Scanner;

import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.ParserInterface;
import VYZ.ErmakovJava.ekzamenzima.datamigrate.parser.exception.ParseException;

public class DataPool<T> {
    // слушает данные // по порту...

    public void  start(ParserInterface<T> parser) {
        System.out.println("DataPool started...");

        Scanner scanner = new Scanner(System.in);
        try{
            while (true) {
                // принимаем данные из поста парсим их в дто чтото с ними делаем и отправляем далее
                String line = scanner.nextLine();
                System.out.println("prinito!: " + line);
                T dto = parser.parse(line);
                // маппим ту джисон но встроенного ту джесон почемуто нету  у джваы
                System.out.println("Parsed DTO: " + dto.toString());
                // класс отправки jsona - пост в другой сервис
            }
        } catch (IllegalStateException ise) {
            System.out.println("Scanner closed");
        }
        catch (ParseException pe) {
            System.out.println("Parse exception: " + pe.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }

}
