package futureCode.pract3_6;

public class repTextFile extends reapText{
    public static void main(String[] args) {
        String fileName="futureCode/pract3_6/input.txt";
        try {
            String line1= revorkString(readtxtFile(fileName));
            writeToFile(line1, fileName);
        } catch (Exception e) {
            System.err.println("Ошибка : "+ e.getMessage());
        }
    }
}
