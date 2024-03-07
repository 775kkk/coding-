package futureCode.pract3_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//№1❗️
public class textRead {
    public static String fileName = "futureCode/pract3_6/userName.txt"; 
    public static int schetWords(String fileName) throws IOException{
        //throws IOException - чтобы не прописывать исключения, а взять их уже из сформировонной конструкции
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
        // Создаем BufferedReader в скобах перед try, чтобы автомотически закрыть BufferedReader,
        // чтобы отдельно в блоке finally не закрывать его, способом выше - автомотически закроется
            String line;
            int wordCount = 0;
            while ((line = reader.readLine())!=null) {
                String[] words = line.split("\\s+");
                wordCount+=words.length;
            }//!=null, чтоб строка не была пустой
            return wordCount;
        }
    }
    public static void main(String[] args) {
        try{//№1❗️
            int wordCount = schetWords(fileName);
            System.out.println("Количество слов в файле : "+ wordCount);
        }catch(IOException e){
            System.err.println("Ошибка при чтении файла! "+ e.getMessage());
            
        }
    }








}
