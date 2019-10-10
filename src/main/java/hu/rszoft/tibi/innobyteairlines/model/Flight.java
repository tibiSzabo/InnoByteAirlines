package hu.rszoft.tibi.innobyteairlines.model;

public class Flight {
    private City from;
    private City destination;
    private String flightNumber;
    private int distance;
    private TimeInterval timeInterval;

    public Flight(City from, City destination, int distance, TimeInterval timeInterval) {
        this.from = from;
        this.destination = destination;
        this.distance = distance;
        this.timeInterval = timeInterval;
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
