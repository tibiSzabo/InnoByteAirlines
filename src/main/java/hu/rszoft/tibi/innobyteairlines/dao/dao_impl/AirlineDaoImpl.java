package hu.rszoft.tibi.innobyteairlines.dao.dao_impl;

import hu.rszoft.tibi.innobyteairlines.dao.BaseDao;
import hu.rszoft.tibi.innobyteairlines.model.Airline;

import java.util.List;

public class AirlineDaoImpl implements BaseDao<Airline> {
    private List<Airline> airlines;

    @Override
    public Airline getById(int id) {
        return null;
    }

    @Override
    public List<Airline> getAll() {
        return null;
    }
}
