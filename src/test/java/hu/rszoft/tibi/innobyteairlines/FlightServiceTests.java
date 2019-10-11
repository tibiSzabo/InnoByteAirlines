package hu.rszoft.tibi.innobyteairlines;

import hu.rszoft.tibi.innobyteairlines.dao.dao_impl.FlightDaoImpl;
import hu.rszoft.tibi.innobyteairlines.model.Flight;
import hu.rszoft.tibi.innobyteairlines.model.Flights;
import hu.rszoft.tibi.innobyteairlines.service.FlightService;
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
public class FlightServiceTests {
    private FlightDaoImpl flightDao;
    private FlightService flightService;
    private List<Flight> flights = new ArrayList<>();
    private Flight flight1 = new Flight("1", "1", "3", "FNO01", 5000, "1", 160 );
    private Flight flight2 = new Flight("2", "2", "3", "FNO02", 696969, "2", 100 );
    private Flight flight3 = new Flight("3", "4", "3", "FNO03", 3000, "2", 100 );

    @Before
    public void setUp() {
        flightDao = new FlightDaoImpl();
        flightService = new FlightService();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        Flights f = new Flights(flights);
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(flightDao, "flights", f);
        ReflectionTestUtils.setField(flightService, "flightDao", flightDao);
    }

    @Test
    public void flightServiceReturnsCorrectFlights() {
        Assert.assertEquals(flightService.getAllFlights(), flights);
    }

    @Test
    public void flightServicegetAllFlightsByCitiesReturnsNullIfArgumentsAreNull() {
        Assert.assertNull(flightService.getAllFlightsByCities(null, null));
    }

    @Test
    public void flightServicegetAllFlightsByCitiesReturnsCorrectFlightsIfFirstArgumentIsNull() {
        Assert.assertEquals(flightService.getAllFlightsByCities(null, "3"), flights);
    }

    @Test
    public void flightServicegetAllFlightsByCitiesReturnsCorrectFlightsIfSecondArgumentIsNull() {
        List<Flight> f = new ArrayList<>();
        f.add(flight2);
        Assert.assertEquals(flightService.getAllFlightsByCities("2", null), f);
    }

    @Test
    public void flightServicegetAllFlightsByCitiesReturnsCorrectFlightsIfWithBothArguments() {
        List<Flight> f = new ArrayList<>();
        f.add(flight2);
        Assert.assertEquals(flightService.getAllFlightsByCities("2", "3"), f);
    }
}
