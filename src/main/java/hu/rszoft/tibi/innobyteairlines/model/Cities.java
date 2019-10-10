package hu.rszoft.tibi.innobyteairlines.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cities {
    @JsonProperty("cities")
    private List<City> cities;

    @JsonCreator
    public Cities(@JsonProperty("cities") List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "cities=" + cities +
                '}';
    }
}
