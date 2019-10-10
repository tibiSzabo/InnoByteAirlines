package hu.rszoft.tibi.innobyteairlines.dao.dao_impl;

import hu.rszoft.tibi.innobyteairlines.dao.BaseDao;
import hu.rszoft.tibi.innobyteairlines.model.Cities;
import hu.rszoft.tibi.innobyteairlines.model.City;
import hu.rszoft.tibi.innobyteairlines.service.XmlParser;

import java.util.List;

public class CityDaoImpl implements BaseDao<City> {
    private Cities cities;

    public CityDaoImpl() {
        XmlParser xmlParser = new XmlParser();
        this.cities = xmlParser.readCities();
    }

    @Override
    public City getById(String id) {
        return this.cities.getCities().stream()
                .filter(city -> city.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<City> getAll() {
        return this.cities.getCities();
    }
}
