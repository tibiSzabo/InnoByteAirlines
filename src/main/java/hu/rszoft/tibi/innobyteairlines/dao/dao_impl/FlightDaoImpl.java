package hu.rszoft.tibi.innobyteairlines.dao.dao_impl;

import hu.rszoft.tibi.innobyteairlines.dao.BaseDao;
import hu.rszoft.tibi.innobyteairlines.model.Flight;
import hu.rszoft.tibi.innobyteairlines.model.Flights;
import hu.rszoft.tibi.innobyteairlines.service.XmlParser;

import java.util.List;

public class FlightDaoImpl implements BaseDao<Flight> {
    private Flights flights;

    public FlightDaoImpl() {
        XmlParser xmlParser1 = new XmlParser();
        this.flights = xmlParser1.readFlights();
    }

    @Override
    public Flight getById(String id) {
        return this.flights.getFlights().stream()
                .filter(flight -> flight.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Flight> getAll() {
        return this.flights.getFlights();
    }
}
