package hu.rszoft.tibi.innobyteairlines.service;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.AirlineDaoImpl;
import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.CityDaoImpl;
import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.FlightDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.Airline;
import hu.rszoft.tibi.innobyteairlines.model.City;
import hu.rszoft.tibi.innobyteairlines.model.Node;
import hu.rszoft.tibi.innobyteairlines.model.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class AirlineService {

    private AirlineDaoImpl airlineDao = new AirlineDaoImpl();
    private FlightDaoImpl flightDao = new FlightDaoImpl();
    private CityDaoImpl cityDao = new CityDaoImpl();

    public List<Flight> getAllFlightsByAirlineId(String airlineId) {
        return this.flightDao.getAll()
                .stream()
                .filter(flight -> flight.getAirline().equals(airlineId))
                .collect(Collectors.toList());
    }

    public List<Airline> getAllAirlines() {
        return this.airlineDao.getAll();
    }

    public String getShortestDistanceUsingOneAirline(String from, String to) {
        List<Airline> airlines = this.getAllAirlines();
        City startCity = cityDao.getById(from);
        City endCity = cityDao.getById(to);

        airlines.forEach(airline -> {

            List<Flight> flightsByAirline = this.getAllFlightsByAirlineId(airline.getId());
            List<Node> unvisited = this.initUnvisitedNodes(flightsByAirline, airline);
            List<Node> visited = new ArrayList<>();
            this.setNodeDistanceFromStart(unvisited, from, 0);

            if (this.flightsContainStartAndDestination(flightsByAirline, from, to)) {
                while (unvisited.size() != 0) {
                    Node currentNode = this.getNodeWithShortestDistanceFromStart(unvisited);
                    flightsByAirline.forEach(flight -> {
                        if (flight.getFrom().equals(currentNode.city)) {
                            this.setNodeDistanceFromStart(unvisited, flight.getDestination(), flight.getDistance());
                            this.setNodePreviousCity(unvisited, flight.getDestination(), currentNode.city);
                        }
                    });
                    unvisited.remove(currentNode);
                    visited.add(currentNode);
                }
            } else {
                System.out.println(airline.getName() + ":");
                System.out.println("Nincs útvonal");
            }
            // TODO
            // Node closest = this.getNodeWithShortestDistanceFromStart(visited);
            System.out.println(airline.getName() + ":");
            System.out.println(startCity.getName() + "->" + endCity.getName() + ": "  + "km.");

        });

        return "";
    }

    private List<Node> initUnvisitedNodes(List<Flight> flightsByAirline, Airline airline) {
        List<String> cities = new ArrayList<>();
        flightsByAirline.forEach(flight -> {
            if (!cities.contains(flight.getFrom())) {
                cities.add(flight.getFrom());
            }
            if (!cities.contains(flight.getDestination())) {
                cities.add(flight.getDestination());
            }
        });
        List<Node> result = new ArrayList<>();
        cities.forEach(city -> {
            Node dist = new Node();
            dist.city = city;
            dist.airline = airline;
            result.add(dist);
        });
        return result;
    }

    private void setNodeDistanceFromStart(List<Node> nodes, String id, int value) {
        nodes.forEach(d -> {
            if (d.city.equals(id)) {
                if (d.distanceFromStart == null || d.distanceFromStart > value) {
                    d.distanceFromStart = value;
                }
            }
        });
    }

    private void setNodePreviousCity(List<Node> nodes, String id, String prev) {
        nodes.forEach(d -> {
            if (d.city.equals(id)) {
                d.previousCity = prev;
            }
        });
    }

    private Node getNodeWithShortestDistanceFromStart(List<Node> nodes) {
        List<Node> nodesWithDistanceFromStart = nodes
                .stream()
                .filter(node -> node.getDistanceFromStart() != null)
                .collect(Collectors.toList());
        return Collections.min(nodesWithDistanceFromStart, Comparator.comparing(Node::getDistanceFromStart));
    }

    private boolean flightsContainStartAndDestination(List<Flight> flightsByAirline, String from, String to) {
        AtomicBoolean containStart = new AtomicBoolean(false);
        AtomicBoolean containDestination = new AtomicBoolean(false);
        flightsByAirline.forEach(flight -> {
            if (flight.getFrom().equals(from)) {
                containStart.set(true);
            }
            if (flight.getDestination().equals(to)) {
                containDestination.set(true);
            }
        });
        return containStart.get() && containDestination.get();
    }
}
