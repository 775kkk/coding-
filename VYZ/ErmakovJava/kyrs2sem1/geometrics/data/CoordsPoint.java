package VYZ.ErmakovJava.kyrs2sem1.geometrics.data;

import java.util.ArrayList;
import java.util.List;

public class CoordsPoint implements Point{
    private List<Integer> valueList;
    private int coutValues;

    public CoordsPoint(int... args){
        this.coutValues = args.length;
        this.valueList = new ArrayList<>(coutValues);
        for (int i = 0; i < coutValues; i++) {
            this.valueList.add(args[i]);
        }
    }
    public ArrayList<Integer> getAllValues(){
        return new ArrayList<Integer>(valueList);
    }
    public int getValueFromList(int index){
        return this.valueList.get(index);
    }
    public void addValue(int value){
        coutValues++;
        this.valueList.add(value);
    }
    public void addValue(int... args){
        for (int i = 0; i < args.length; i++) {
            coutValues++;
            this.valueList.add(args[i]);
        }
    }
    public int popValue(){
        try {
            return this.valueList.remove(--coutValues);
        } catch (Exception e) {
            throw new Error("exception");
        }
    }
    public int removeValue(int index){
        try {
            this.coutValues--;
            return this.valueList.remove(index);
        } catch (Exception e) {
            throw new IllegalArgumentException("index not found");
        }
    }
    @Override
    public String getInfo() {
        String ret = "Coordinates : ";
        for (int i = 0; i < coutValues; i++) {
            ret+=this.valueList.get(i)+", ";
        }
        return ret.trim();
    }
}
