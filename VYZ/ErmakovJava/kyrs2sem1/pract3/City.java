package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String cityName;
    private List<Road> roadList;
    // 
    // конструктор мейн, конструктор без имени - номер от статики(id)
    // ,конструктор копии, конструктор с аргументами типа Road, 
    // см далее примеры построения класса роад полилейн точки студента

    public City(String cityName,List<Road> roadList){
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
        for (Road road : roadList) {
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

}
