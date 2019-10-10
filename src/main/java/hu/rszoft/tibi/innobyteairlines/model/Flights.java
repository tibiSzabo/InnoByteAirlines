package hu.rszoft.tibi.innobyteairlines.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flights {

    @JsonProperty("flights")
    private List<Flight> flights;

    @JsonCreator
    public Flights(@JsonProperty("flights") List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flights=" + flights +
                '}';
    }
}
