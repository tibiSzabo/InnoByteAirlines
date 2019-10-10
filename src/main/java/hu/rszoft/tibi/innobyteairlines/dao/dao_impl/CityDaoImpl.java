package hu.rszoft.tibi.innobyteairlines.dao.dao_impl;

import hu.rszoft.tibi.innobyteairlines.dao.BaseDao;
import hu.rszoft.tibi.innobyteairlines.model.City;

import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements BaseDao<City> {
    private List<City> cities;

    @Override
    public City getById(int id) {
        return cities.stream()
                .filter(city -> city.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public List<City> getAll() {
        return new ArrayList<>(cities);
    }
}
