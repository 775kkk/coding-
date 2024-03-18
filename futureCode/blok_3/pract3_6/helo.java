package futureCode.blok_3.pract3_6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class helo {
    private static String WhatISyourName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя :");
        return scanner.nextLine();
        
    }
    private static void writeToFile(String content, String fileName){
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(content);
        }catch(IOException e){
            System.err.println("Ошибка при записи в файл : "+ e.getMessage());
        }
    }
    public static void haloUser(String userName){
        System.out.println("halo!, "+userName+".");
    }
    public static void main(String[] args) {
        String userName = WhatISyourName();
        writeToFile(userName, "futureCode/blok_3/pract3_6/userName.txt");
        haloUser(userName);
    }




}
