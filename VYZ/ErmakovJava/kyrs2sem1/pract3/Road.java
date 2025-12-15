package VYZ.ErmakovJava.kyrs2sem1.pract3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Road {
    private String roadName;// дефолт роаднейма будет соедененное название двух городов
    private List<City> linkedCitiesList;// может список сделать отдельной сучностью и у него поведения определить?????????
    private int costRoute;


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

    public Road(String roadName,  int costRoute,List<City> linkedCitiesList){
        if (costRoute<0) throw new IllegalArgumentException("costRoute < 0");
        this.linkedCitiesList = linkedCitiesList!=null ? new ArrayList<City>(linkedCitiesList) : new ArrayList<City>();
        this.roadName = roadNameCounted(roadName);
        this.costRoute = costRoute;
        
    }
    public Road(List<City> linkedCitiesList, int costRoute){
        this(null, costRoute, linkedCitiesList);
    }
    public Road(int costRoute,City... argsOfCities) {
        this(null, costRoute, Arrays.asList(argsOfCities));
    }
    public Road(String roadName, int costRoute){
        this(roadName, costRoute, null);
    }
    public Road(Road road){
        this(road.getRoadName(),road.getCostRoute(),road.getLinkedCitiesList());
    }

    public void setLinkedCities(List<City> linkedCitiesList) {
        this.linkedCitiesList = new ArrayList<City>(linkedCitiesList);
    }
    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }
    public void setCostRoute(int costRoute) {
        this.costRoute = costRoute;
    }

    public List<City> getLinkedCitiesList() {
        return new ArrayList<City>(linkedCitiesList);
    }
    public String getRoadName() {
        return roadName;
    }
    public int getCostRoute() {
        return costRoute;
    }

    public void addCity(City city){
        city.addNewRoadToRoadList(this);// вызываем метод сити где он Добавляет новую дорогу в список дорог
        this.addCityToCityList(city);//вызываем метод дороги для записи города в список дороги.
    }

    public void addCityToCityList(City city){
        this.linkedCitiesList.add(city);
    }
    public void addCityToCityList(City... argsOfCities){
        for (City city : argsOfCities) {
            this.addCityToCityList(city);
        }
    }

    public City getCityOnIndex(int index){// НЕ КОПИЯ
        return this.linkedCitiesList.get(index);
    }
    public void popCityFromCityList(){
        this.linkedCitiesList.get(this.linkedCitiesList.size()-1).removeRoadFromRoadListByObject(this);
        this.linkedCitiesList.remove(this.linkedCitiesList.size()-1);

    }
    public void removeCityFromCityListByIndex(int index){
        (this.linkedCitiesList.get(index)).removeRoadFromRoadListByObject(this);
        this.linkedCitiesList.remove(index);
    }
    public void removeCityFromCityListByObject(City city){
        this.linkedCitiesList.remove(city);
    }

    public String getCityNamesFromCityListToString(){
        if (this.linkedCitiesList.isEmpty()) {
            return "No linked Cities";
        }
        String retStr="";
        // for (City city : this.linkedCitiesList) {
        //     retStr+=" "+city.getCityName();
        // }
        for (int i = 0; i < this.linkedCitiesList.size(); i++) {
            if (i== this.linkedCitiesList.size()-1) {
                retStr+=" "+this.linkedCitiesList.get(i).getCityName();
            }else{
                retStr+=" "+this.linkedCitiesList.get(i).getCityName()+",";
            }
        }
        return retStr;
    }

    // clearить список с последующими отвязками

    @Override
    public String toString() {
        return "Road "+this.roadName+"; Cities:"+getCityNamesFromCityListToString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Road road = (Road) o;
        
        return costRoute == road.costRoute &&
            Objects.equals(roadName, road.roadName) &&
            new HashSet<>(linkedCitiesList).equals(new HashSet<>(road.linkedCitiesList));
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadName, costRoute, new HashSet<>(linkedCitiesList));
    }
}
