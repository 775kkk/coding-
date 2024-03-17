package futureCode.pract3_7;
// import futureCode.pract3_7.calcorator;//хз поч закомментить можно, предположения есть но не точное понимание...
// тип тк в одной директории?
public class forcalco {
    public static double a = 2.0;
    public static double b = 4.0;
    // static вроде показывает принадлежность к объекту класса...
    public double af = 3.0;
    public double bf = 5.0;
    // типа это вот экземпляр класса, тоесть типа конкретный из мнежества чтоле?
    // и в нем статик значения принадлежат типа сразу всем множествам и они там конст???
    public static void main(String[] args) {
        calcorator calculator = new calcorator();
        System.out.println("Площадь круга "+ calculator.calco(a));

        forcalco instance = new forcalco();

        System.out.println("Площадь второго круга "+ calculator.calco(instance.af));

        System.out.println("Полощадь ректангла хахах "+ calculator.calco(a, b));
        
        System.out.println("Площадь второго ректангла "+calculator.calco(instance.af, instance.bf));
    }

}
