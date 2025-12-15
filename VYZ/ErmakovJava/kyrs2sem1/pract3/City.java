package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class City {
    private String cityName;
    private List<Road> roadList;

    public City(String cityName,List<Road> roadList){
        if (cityName==null) throw new IllegalArgumentException("cityName == null");
        this.cityName = cityName;
        this.roadList = (roadList != null) ? new ArrayList<Road>(roadList) : new ArrayList<Road>();
    }
    public City(String cityName){
        this(cityName, null);
    }
    public City(City city){
        this(city.getCityName(),city.getRoadList());
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public void setRoadList(List<Road> roadList) {
        if (roadList==null) throw new IllegalArgumentException("roadList == null");
        for (Road road : this.roadList) {
            road.removeCityFromCityListByObject(this);
        }
        this.roadList = new ArrayList<Road>(roadList);
    }

    public String getCityName() {
        return cityName;
    }
    public List<Road> getRoadList() {
        return new ArrayList<Road>(roadList);
    }

    public void addNewRoadToRoadList(Road road){
        this.roadList.add(road);
    }
    public void addNewRoad(Road road){
        this.addNewRoadToRoadList(road);
        road.addCityToCityList(this);
    }
    public void addNewRoadToRoadList(Road... argsOfRoads){
        for (Road road : argsOfRoads) {
            this.addNewRoad(road);
        }
    }

    public List<City> neighbors(){// все города связанных дорог
        HashSet<City> ret = new HashSet<City>();
        for (Road road : roadList) {
            for (City city : road.getLinkedCitiesList()) {
                if (!this.equals(city)) {
                    ret.add(city);
                }
            }
        }
        return new ArrayList<City>(ret);
    }

    public Road getRoadOnIndex(int index){// НЕ КОПИЯ
        return this.roadList.get(index);
    }
    public void popRoadFromRoadList(){
        this.roadList.get(this.roadList.size()-1).removeCityFromCityListByObject(this);
        this.roadList.remove(this.roadList.size()-1);

    }
    public void removeCityFromCityListByIndex(int index){
        (this.roadList.get(index)).removeCityFromCityListByObject(this);;
        this.roadList.remove(index);
    }
    public void removeRoadFromRoadListByObject(Road road){// в класс списка???
        this.roadList.remove(road);
    }

    public String getRoadNamesFromRoadListToString(){
        if (this.roadList.isEmpty()) {
            return "No linked Roads";
        }
        String retStr="";
        for (int i = 0; i < this.roadList.size(); i++) {
            if (i==this.roadList.size()-1) {
                retStr+=" "+this.roadList.get(i).getRoadName();
            }else{
                retStr+=" "+this.roadList.get(i).getRoadName()+",";
            }
        }
        return retStr;
    }

    // clearить список с последующими отвязками

    @Override
    public String toString() {
        return "Cities "+this.cityName+"; Roads:"+getRoadNamesFromRoadListToString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        City city = (City) o;
        return Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }

}
