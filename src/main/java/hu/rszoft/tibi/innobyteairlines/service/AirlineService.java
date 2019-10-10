package hu.rszoft.tibi.innobyteairlines.service;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.AirlineDaoImpl;
import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.FlightDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AirlineService {

    private AirlineDaoImpl airlineDao = new AirlineDaoImpl();
    private FlightDaoImpl flightDao = new FlightDaoImpl();

    public List<Flight> getAllFlightsByAirlineId(String airlineId) {
        return this.flightDao.getAll()
                .stream()
                .filter(flight -> flight.getAirline().equals(airlineId))
                .collect(Collectors.toList());
    }

}
