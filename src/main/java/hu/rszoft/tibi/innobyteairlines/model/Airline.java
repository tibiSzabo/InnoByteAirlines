package hu.rszoft.tibi.innobyteairlines.model;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private String name;
    private List flights = new ArrayList<Flight>();

    public Airline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getFlights() {
        return flights;
    }

    public void setFlights(List flights) {
        this.flights = flights;
    }
}
