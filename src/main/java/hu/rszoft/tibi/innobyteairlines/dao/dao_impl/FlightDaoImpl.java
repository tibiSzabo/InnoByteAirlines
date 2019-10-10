package hu.rszoft.tibi.innobyteairlines.dao.dao_impl;

import hu.rszoft.tibi.innobyteairlines.dao.BaseDao;
import hu.rszoft.tibi.innobyteairlines.model.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements BaseDao<Flight> {
    private List<Flight> flights;

    @Override
    public Flight getById(int id) {
        return flights.stream()
                .filter(flight -> flight.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Flight> getAll() {
        return new ArrayList<>(flights);
    }
}
