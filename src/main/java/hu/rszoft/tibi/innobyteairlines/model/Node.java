package hu.rszoft.tibi.innobyteairlines.model;

public class Node {
    public String city;
    public Integer distanceFromStart = null;
    public String previousCity;
    public Airline airline;

    public String getCity() {
        return city;
    }

    public Integer getDistanceFromStart() {
        return distanceFromStart;
    }

    public String getPreviousCity() {
        return previousCity;
    }

    public Airline getAirline() {
        return airline;
    }

}
