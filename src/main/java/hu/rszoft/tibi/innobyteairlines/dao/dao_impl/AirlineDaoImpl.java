package hu.rszoft.tibi.innobyteairlines.dao.dao_impl;

import hu.rszoft.tibi.innobyteairlines.dao.BaseDao;
import hu.rszoft.tibi.innobyteairlines.model.Airline;
import hu.rszoft.tibi.innobyteairlines.model.Airlines;
import hu.rszoft.tibi.innobyteairlines.service.XmlParser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public class AirlineDaoImpl implements BaseDao<Airline> {
    private Airlines airlines;

    public AirlineDaoImpl() {
        XmlParser xmlParser = new XmlParser();
        this.airlines = xmlParser.readAirlines();
    }

    @Override
    public Airline getById(String id) {
        return this.airlines.getAirlines().stream()
                .filter(airline -> airline.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Airline> getAll() {
        return this.airlines.getAirlines();
    }
}
