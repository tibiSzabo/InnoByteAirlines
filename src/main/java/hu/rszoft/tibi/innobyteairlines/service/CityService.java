package hu.rszoft.tibi.innobyteairlines.service;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.CityDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.City;

import java.util.Collections;
import java.util.Comparator;

public class CityService {

    private CityDaoImpl cityDao = new CityDaoImpl();

    public City getBiggestCity() {
        return Collections.max(cityDao.getAll(), Comparator.comparing(City::getPopulation));
    }

    public City getSmallestCity() {
        return Collections.min(cityDao.getAll(), Comparator.comparing(City::getPopulation));
    }

}
