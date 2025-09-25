package VYZ.ErmakovJava.kyrs2sem1.pract1.testZadacha;

// import java.util.Arrays;

public class DynamicMass{
    private int[] mass;
    private int factlen;

    public int size() {
        return this.factlen;
    }

    private void lengthCorrection(int minlen) {
        if (this.mass.length >= minlen) return ;
        int[] temp = new int[Math.max((int)(this.mass.length*1.5)+1, minlen)];
        System.arraycopy(this.mass, 0, temp, 0, this.factlen); // копируем ток по фактлен
        this.mass = temp;
    }

    public DynamicMass(){
        mass = new int[0];
        factlen=0;
    }
    
    public DynamicMass(int len) {
        if (len < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + len);
        }
        this.mass = new int[len];
        this.factlen = 0;
    }
    public DynamicMass(int[] arr){
        toDynamic(arr);
    }

    public void toDynamic(int[] arr){
        // в динамический массив 
        if (arr == null) throw new NullPointerException("arr cannot be null");
        this.mass = new int[arr.length];
        System.arraycopy(arr, 0, this.mass, 0, arr.length);
        this.factlen = arr.length;
    }

    public void add(int chislo){
        lengthCorrection(this.factlen + 1);
        this.mass[factlen++] = chislo;
    }

    public void insert(int index, int chislo) { // вставка с сдвигом 
        if (index < 0) throw new IndexOutOfBoundsException("array index < 0");
        lengthCorrection(index + 1);// корректируем сразу, учитывая случаи когда индекс за пределами факт и практической длин
        if (index < this.factlen){// внутри фактической длиннны
            System.arraycopy(this.mass, index, this.mass, index + 1, this.factlen - index);// невероятно удобное копирование чота магическое
            this.mass[index] = chislo;
            this.factlen++;
        } else if (index == factlen){
            this.mass[this.factlen++] = chislo;
        } else { // index > factlen: устраивает промежуток 
            this.mass[index] = chislo;
            this.factlen = index + 1;
        }
    }

    public void replase(int chislo, int index){
        if (index < 0) throw new IndexOutOfBoundsException("array index < 0");
        if (index >= this.factlen) throw new IndexOutOfBoundsException("array index out of range");
        this.mass[index]=chislo;
    }
    
    public void remove(int index){
        if (index < 0) throw new IndexOutOfBoundsException("array index < 0");
        if (index > this.factlen) throw new IndexOutOfBoundsException("array index > size");
         System.arraycopy(this.mass, index + 1, this.mass, index, this.factlen - index - 1);
         this.factlen--;
         // резонно ли делать уменьшение lenght массива?? -> метод для ручной оптимизации?
    }

    @Override
    public String toString() {
        // String retString = "[";
        // for (int i = 0; i < this.factlen; i++) {
        //     retString+=this.mass[i];
        //     if (!(i==this.factlen-1)) {
        //         retString+=", ";
        //     }
        // }
        // retString+="]";
        StringBuilder retString = new StringBuilder();
        retString.append("[");
        for (int i = 0; i < this.factlen; i++) {
            retString.append(this.mass[i]);
            if (!(i==this.factlen-1)) {
                retString.append(", ");
            }
        }
        retString.append("]");
        return retString.toString();
    }

    public int getLenght(){
        return this.mass.length;
    }
    public int getValue(int index){
        return this.mass[index];
    }
}
// to do : TRIM - оптимизация , реализовать гедмасс - копия массива