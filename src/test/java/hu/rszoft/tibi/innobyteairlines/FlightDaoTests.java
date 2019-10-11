package hu.rszoft.tibi.innobyteairlines;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.FlightDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.Flight;
import hu.rszoft.tibi.innobyteairlines.model.Flights;
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
public class FlightDaoTests {
    private FlightDaoImpl flightDao;
    private List<Flight> flights = new ArrayList<>();
    private Flight flight1 = new Flight("1", "1", "2", "FNO01", 5000, "1", 160 );
    private Flight flight2 = new Flight("2", "2", "3", "FNO02", 3000, "2", 100 );

    @Before
    public void setUp() {
        flightDao = new FlightDaoImpl();
        flights.add(flight1);
        flights.add(flight2);
        Flights f = new Flights(flights);
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(flightDao, "flights", f);
    }

    @Test
    public void flightDaoReturnsCorrectFlights() {
        Assert.assertEquals(flightDao.getAll(), flights);
    }

    @Test
    public void setFlightDaoReturnsCorrectFlight() {
        Assert.assertEquals(flightDao.getById("1"), flight1);
        Assert.assertEquals(flightDao.getById("2"), flight2);
    }
}
