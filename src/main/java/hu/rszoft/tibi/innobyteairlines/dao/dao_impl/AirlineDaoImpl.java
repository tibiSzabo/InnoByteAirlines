package hu.rszoft.tibi.innobyteairlines.dao.dao_impl;

import hu.rszoft.tibi.innobyteairlines.dao.BaseDao;
import hu.rszoft.tibi.innobyteairlines.model.Airline;

import java.util.ArrayList;
import java.util.List;

public class AirlineDaoImpl implements BaseDao<Airline> {
    private List<Airline> airlines;

    @Override
    public Airline getById(int id) {
        return this.airlines.stream()
                .filter(airline -> airline.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Airline> getAll() {
        return new ArrayList<>(this.airlines);
    }
}
