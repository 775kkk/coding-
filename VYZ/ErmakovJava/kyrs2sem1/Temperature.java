package VYZ.ErmakovJava.kyrs2sem1;

public class Temperature {
    private Status Name;
    private int temperatureValue;

    public enum Status {
        Холодно,
        Нормально,
        Тепло,
        Unnormal
    }
    public enum TemperatureT{
        TEMPERATURE_COLD(-50,10);
        int from;
        int to;

        TemperatureT(int from, int to){
            this.to = to;
            this.from = from;
        }
    }
    
    private static Status generateStatus(int temperatureValue){
        if(temperatureValue <-50 || temperatureValue >10){
            return Status.Холодно;
        }
        else if(temperatureValue >=10 && temperatureValue <=25){
            return Status.Нормально;
        }
        else if(temperatureValue >25 && temperatureValue <=60){
            return Status.Тепло;
        }
        else{
            return Status.Unnormal;
        }
    }

    private Temperature(Status status, int temperatureValue){
        this.Name=status;
        this.temperatureValue=temperatureValue;
    }
    public static Temperature of(int temperatureValue){
        return new Temperature(generateStatus(temperatureValue), temperatureValue);
    }


}
