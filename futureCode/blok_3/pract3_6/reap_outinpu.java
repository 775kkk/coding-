package futureCode.blok_3.pract3_6;

public class reap_outinpu extends reapText{
    public static void main(String[] args) {
        String fileNameRead="futureCode/blok_3/pract3_6/output.txt";
        String fileNameWrite="futureCode/blok_3/pract3_6/input.txt";
        try {
            String line1= revorkString(readtxtFile(fileNameRead));
            writeToFile(line1, fileNameWrite);
        } catch (Exception e) {
            System.err.println("Ошибка : "+ e.getMessage());
        }
    }//№4
}
