package hu.rszoft.tibi.innobyteairlines.model;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String id;
    private String name;
    private List flights = new ArrayList<Flight>();

    public Airline(String id, String name, List flights) {
        this.id = id;
        this.name = name;
        this.flights = flights;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List getFlights() {
        return flights;
    }
}
