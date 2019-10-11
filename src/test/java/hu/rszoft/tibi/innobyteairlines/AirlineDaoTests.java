package hu.rszoft.tibi.innobyteairlines;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.AirlineDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.Airline;
import hu.rszoft.tibi.innobyteairlines.model.Airlines;
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
public class AirlineDaoTests {
    private AirlineDaoImpl airlineDao;
    private List<Airline> airlines = new ArrayList<>();
    private Airline airline1 = new Airline("1", "Airline1");
    private Airline airline2 = new Airline("2", "Airline2");

    @Before
    public void setUp() {
        airlineDao = new AirlineDaoImpl();
        airlines.add(airline1);
        airlines.add(airline2);
        Airlines a = new Airlines(airlines);
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(airlineDao, "airlines", a);
    }

    @Test
    public void airlineDaoReturnsAllAirlines() {
        Assert.assertEquals(airlineDao.getAll(), airlines);
    }

    @Test
    public void airlineDaoReturnsCorrectAirlineById() {
        Assert.assertEquals(airlineDao.getById("1"), airline1);
        Assert.assertEquals(airlineDao.getById("2"), airline2);
    }
}


