package hu.rszoft.tibi.innobyteairlines.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Airlines {

    @JsonProperty("airlines")
    private List<Airline> airlines;

    @JsonCreator
    public Airlines(@JsonProperty("airlines") List<Airline> airlines) {
        this.airlines = airlines;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }

    @Override
    public String toString() {
        return "Airlines{" +
                "airlines=" + airlines +
                '}';
    }
}
