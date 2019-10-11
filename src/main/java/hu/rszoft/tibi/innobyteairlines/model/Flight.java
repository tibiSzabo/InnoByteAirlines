package hu.rszoft.tibi.innobyteairlines.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flight {

    @JsonProperty("id")
    private String id;

    @JsonProperty("from_city_id")
    private String from;

    @JsonProperty("destination_city_id")
    private String destination;

    @JsonProperty("flight_number")
    private String flightNumber;

    @JsonProperty("distance")
    private int distance;

    @JsonProperty("airline_id")
    private String airline;

    @JsonProperty("duration")
    private int duration;

    @JsonCreator
    public Flight(@JsonProperty("id") String id,
                  @JsonProperty("from_city_id") String from,
                  @JsonProperty("destination_city_id") String destination,
                  @JsonProperty("flight_number") String flightNumber,
                  @JsonProperty("distance") int distance,
                  @JsonProperty("airline_id") String airline,
                  @JsonProperty("duration") int duration) {
        this.id = id;
        this.from = from;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.distance = distance;
        this.airline = airline;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", from=" + from +
                ", destination=" + destination +
                ", flightNumber='" + flightNumber + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}
