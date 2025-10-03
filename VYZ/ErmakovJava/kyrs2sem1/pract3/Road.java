-package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import futureCode.blok_3.pract3_7.forcalco;

public class Road {
    private String roadName;// дефолт роаднейма будет соедененное название двух городов
    private  List<City> linkedCitiesList;

    private String roadNameCounted(String roadName){
        if (roadName==null){
            if (this.linkedCitiesList.size() >=2) {
                return 
                this.linkedCitiesList.get(0).getCityName()+" - "
                +this.linkedCitiesList.get(1).getCityName();
            }
            if (this.linkedCitiesList.size()==1) {
                return this.linkedCitiesList.get(0).getCityName();
            }
        }
        return roadName;
        
    }
    public Road(String roadName, List<City> linkedCitiesList){
        this.linkedCitiesList = new ArrayList<City>(linkedCitiesList);
        this.roadName = roadNameCounted(roadName);
        
    }
    public Road(List<City> linkedCitiesList){
        this(null, linkedCitiesList);
    }
    public Road(City... argsOfCities) {
        this(null, Arrays.asList(argsOfCities));
    }

    public void setLinkedCities(List<City> linkedCitiesList) {
        this.linkedCitiesList = new ArrayList<City>(linkedCitiesList);
    }
    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public List<City> getLinkedCitiesList() {
        return new ArrayList<City>(linkedCitiesList);
    }
    public String getRoadName() {
        return roadName;
    }

    public void addCities(City city){
        this.linkedCitiesList.add(new City(city));
    }
    public void addCities(City... argsOfCities){
        for (City city : argsOfCities) {
            this.addCities(city);
        }
    }

    public City getCityOnIndex(int index){// НЕ КОПИЯ
        return this.linkedCitiesList.get(index);
    }
    public void popCityInRoadList(){
        this.linkedCitiesList.remove(this.linkedCitiesList.size()-1);
    }
    public void removeCityInRoadListByIndex(int index){
        this.linkedCitiesList.remove(index);
    }

    public String getCitiesNamesInListToString(){
        if (this.linkedCitiesList.isEmpty()) {
            return "No linked Cities";
        }
        String retStr;
        for (City city : this.linkedCitiesList) {
            retStr+=" "+city.getCityName();
        }
        return retStr;
    }

    @Override
    public String toString() {
        return "Road "+this.roadName+"; Cities:"+getCitiesNamesInListToString();
    }
}
