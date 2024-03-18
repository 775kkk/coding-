package futureCode.blok_3.pract3_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class reapText {
    public static String readtxtFile(String fileName) throws IOException{
        String line;
        String wline="";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while ((line = reader.readLine())!=null) {
                wline += line;
            }
            return wline;
        }// из за throws IOException функция readtxtFile() может вернуть ошибку, 
        //если так, то сама функция должна строго вызываться в конструкции try-catch
    }
    public static String revorkString(String txt){
        String retxt="";
        for (int i = 0; i < txt.length(); i++) {
            retxt+=txt.charAt((txt.length())-i-1);
        }
        return retxt;
    }
    public static void writeToFile(String content, String fileName){
        try(FileWriter writer = new FileWriter(fileName)){
            writer.write(content);
        }catch(IOException e){
            System.err.println("Ошибка при записи в файл : "+ e.getMessage());
        }
    }//🔄📂👨‍💻
    public static void main(String[] args) {//№3
        String fileNameRead="futureCode/blok_3/pract3_6/input.txt";
        String fileNameWrtire="futureCode/blok_3/pract3_6/output.txt";
        try{
        String line1= revorkString(readtxtFile(fileNameRead));
        writeToFile(line1, fileNameWrtire);
        }catch(IOException e){
        System.err.println("Ошибка : "+ e.getMessage());
        }//покопался минут 40
    }
}
