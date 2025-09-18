package VYZ.ErmakovJava.kyrs2sem1.pract1;

public class time114 {
    private int timesec = 0;

    public int getTime(){
        return this.timesec;
    }
    public void setTime(int time){
        this.timesec = time;
    }
    
    public time114(int sec){
        this.timesec = sec;
    }

    @Override
    public String toString() {
        return ""+(timesec/(60*60))%24+":" + (timesec/(60))%60 +":"+ (timesec)%60;
    }
}
