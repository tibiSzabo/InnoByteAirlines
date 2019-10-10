package hu.rszoft.tibi.innobyteairlines.model;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String name;
    private List flights = new ArrayList<Flight>();

    public Airline(String name, List flights) {
        this.name = name;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public List getFlights() {
        return flights;
    }
}
