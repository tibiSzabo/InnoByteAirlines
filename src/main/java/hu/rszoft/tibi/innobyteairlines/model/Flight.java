package hu.rszoft.tibi.innobyteairlines.model;

public class Flight {
    private String id;
    private City from;
    private City destination;
    private String flightNumber;
    private int distance;
    private TimeInterval timeInterval;

    public Flight(String id, City from, City destination, String flightNumber, int distance, TimeInterval timeInterval) {
        this.id = id;
        this.from = from;
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.distance = distance;
        this.timeInterval = timeInterval;
    }

    public String getId() {
        return id;
    }

    public City getFrom() {
        return from;
    }

    public City getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public int getDistance() {
        return distance;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }
}
