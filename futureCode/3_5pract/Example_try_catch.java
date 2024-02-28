
public class Example_try_catch {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try{
            int res = a/b;
            System.out.println("res == "+res);
        }catch(ArithmeticException e){
            // NullPointerException e -- если переменная = null
            // ArrayIndexOutOfBounds e -- выход за пределы массива
            // NumberFormatException e -- ошибка преобразования строки в число

            System.out.println("Ошибка деления");
            //кетчи можно юзать много, примерно по каждому на ошибку...
            

        }finally{
            System.out.println("Конец");
        }
    }       
}