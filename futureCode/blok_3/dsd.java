package futureCode.blok_3;

import java.util.Scanner;
import java.util.InputMismatchException;
public class dsd {
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int a = scanner.nextInt();
    //     int c = 0;
    //         for (int i = 0; i <= a; i++) {
    //             if ((i % 10 == 5) && (Math.pow(i, 0.5) == (int) Math.pow(i, 0.5))) {
    //                 c++;
    //             }
    //         }
    //     System.out.println(c);
    // }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите колво поездок");
        int n=0;
        try{
            n = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Ошибка");
        }
        int mxT=0;
        String mxTs="";
        int mxP=0;
        String mxPs="";
        try{for (int i = 0; i < n; i++) {
            System.out.println("Введите время в минутах");
            int t = scanner.nextInt();
            System.out.println("Введите колво людей");
            int p = scanner.nextInt();
            System.out.println("Введите номер поездки");
            String b = scanner.nextLine();
            if (t>mxT){mxT=t;mxTs=b;}
            if (p>mxP){mxP=p;mxPs=b;}
        }}catch(InputMismatchException e){
            System.out.println("Ошибка");
        }
        System.out.println("Маршрут с максимальным временем поездки -> "+mxTs+" Составил "+mxT+" мин ");
        System.out.println("Маршрут с максимальным количеством пассажиров -> "+mxPs+" пассажиров -> "+mxP);


    }
}
