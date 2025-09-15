package VYZ.ErmakovJava.kyrs2sem1.pract1.testZadacha;

public class DynamicMass{
    // int baseSize=10;
    // int[] mass = new int[baseSize];
    // void ToDynamic(int[] arr){
    //     if (mass.length != arr.length) {
    //         this.baseSize*=1.5;
    //         mass = new int[baseSize];
    //     }
    //     for (int i = 0; i < arr.length; i++) {
    //         mass[i]=arr[i];
    //     }
    // }

    // void appendToMassive(int chislo){
    //     if (mass.length+1 > this.baseSize) {
    //         this.baseSize*=1.5;
    //         int[] temp = mass;
    //         mass = new int[baseSize];
    //     }
        
    // }
    int[] mass ;
    void toDynamic(int[] arr){
        mass = new int[arr.length];
        
    }

}
