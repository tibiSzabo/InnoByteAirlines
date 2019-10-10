package hu.rszoft.tibi.innobyteairlines.service;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.AirlineDaoImpl;
import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.CityDaoImpl;
import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.FlightDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private AirlineDaoImpl airlineDao = new AirlineDaoImpl();
    private FlightDaoImpl flightDao = new FlightDaoImpl();
    private CityDaoImpl cityDao = new CityDaoImpl();

    public List<Flight> getAllFlights() {
        return this.flightDao.getAll();
    }

    public List<Flight> getAllFlightsByCities(String fromId, String destinationId) {
        if (fromId == null && destinationId == null) {
            return null;
        } else if (fromId == null) {
            return flightDao.getAll()
                    .stream()
                    .filter(flight -> flight.getDestination().equals(destinationId))
                    .collect(Collectors.toList());
        } else if (destinationId == null) {
            return flightDao.getAll()
                    .stream()
                    .filter(flight -> flight.getFrom().equals(fromId))
                    .collect(Collectors.toList());
        } else {
            return flightDao.getAll()
                    .stream()
                    .filter(flight -> flight.getFrom().equals(fromId) && flight.getDestination().equals(destinationId))
                    .collect(Collectors.toList());
        }
    }



}
