package VYZ.ErmakovJava.kyrs2sem1.pract1;

import java.util.Arrays;

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
// 3. Ср арифм
    public static Integer srArifm(int[] args){
        try{ return Arrays.stream(args).sum()/args.length; }
        // arg = {1,2,4}
        // Arrays.stream(args) => 1 2 4 превращает в поток данных 
        // массив императивная старая структура данных (int[].sum() - дурак?)
        // потоки (streams) декларативная (stream.sum() - красавчик)
        // arrays.stream(int[]) - объект обработчик получающий данные из массива и что-то с ними делает(.sum())
        // -> объект IntStream - интерфейс который определяет как можно работать с int последоватеьностью
        catch (Exception e){ return null; }
    } 
// 4. метод инсерт 
    // @Override
    public static int[] insert(int[] arr, int index, int value){
        if (arr.length < index) {
            return arr;
        }
        int[] retArr = new int[arr.length+1];
        for (int i = 0; i < arr.length+1; i++) {
            if(i<index){
                retArr[i]=arr[i];
                continue;
            }
            if(i>index){
                retArr[i+1]=arr[i];
                continue;
            }
            // 4
            retArr[i]=value;
            
        }
        return arr;
    }

    public static void main(String[] args) {
        // System.out.println(isNumber("null"));
        // System.out.println(isNumber("1"));
        // System.out.println(toInt("-1"));
        // System.out.println(toInt("122"));
        int[] arg = {1, 2, 4, 6,10};
        // System.err.println("zzz :"+ srArifm(arg));
        // try{
        //     System.out.println(1+toInt("4"));
        // } catch(Exception e){
        //     System.out.println("-_-");
        // }
        arg = insert(arg, 0, 1);
        // System.out.println(Arrays.toString(arg)+"\n");

        for (int i = 0; i < arg.length; i++) {
            System.out.println(arg[i]);
        }
    }
}
