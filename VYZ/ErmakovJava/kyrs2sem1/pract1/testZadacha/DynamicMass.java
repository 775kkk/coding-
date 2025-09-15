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
    int factlen;
    int mnimlen;
    void toDynamic(int[] arr){
        // в динамический массив 
        this.mass = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.mass[i]=arr[i];
        }
        // обнулить arr?
        this.factlen=arr.length;
    }
    void add(int chislo){
        try {// по сути можно проверку на факт длину и физ длину
            this.mass[factlen]=chislo;
            
        } catch (Exception e) {
            int[] temp = this.mass;
            this.mnimlen = (int)(factlen*1.5);
            this.mass = new int[mnimlen];
            for (int i = 0; i < temp.length; i++) {
                mass[i]=temp[i];
            }
            mass[factlen]=chislo;
        }
        this.factlen+=1;
    }

    void length(){
        // this.mass[-1]==this.mass[mnimlen] ?
        
    }

}
