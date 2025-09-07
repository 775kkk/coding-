package VYZ.ErmakovJava.kyrs2sem1.pract1;

public class dzpr1 {   
// 1.проверить является ли строка числом
    public static boolean isNumber(String str){
        try { Integer.parseInt(str.trim()); return true; }
        catch (Exception e) { return false; }
    }

// 2.препвести строку в число
    public static int toInt(String str) {
        return Integer.parseInt(str.trim());
    }
    public static void main(String[] args) {
        System.out.println(isNumber("null"));
        System.out.println(isNumber("1"));
        System.out.println(toInt("1"));
        try{
            System.out.println(1+toInt("4"));
        } catch(Exception e){
            System.out.println("-_-");
        }
    }
}
