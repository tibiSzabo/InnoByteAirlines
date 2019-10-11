package hu.rszoft.tibi.innobyteairlines;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.CityDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.Cities;
import hu.rszoft.tibi.innobyteairlines.model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityDaoTests {
    private CityDaoImpl cityDao;
    private List<City> cities = new ArrayList<>();
    private City city1 = new City("1", "City1", 500);
    private City city2 = new City("2", "City2", 1000);
    private City city3 = new City("3", "City3", 1500);

    @Before
    public void setUp() {
        cityDao = new CityDaoImpl();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        Cities c = new Cities(cities);
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(cityDao, "cities", c);
    }

    @Test
    public void cityDaoReturnsAllCities() {
        Assert.assertEquals(cityDao.getAll(), cities);
    }

    @Test
    public void cityDaoReturnsCorrectCityById() {
        Assert.assertEquals(cityDao.getById("1"), city2);
        Assert.assertEquals(cityDao.getById("2"), city2);
        Assert.assertEquals(cityDao.getById("3"), city3);
    }

}

