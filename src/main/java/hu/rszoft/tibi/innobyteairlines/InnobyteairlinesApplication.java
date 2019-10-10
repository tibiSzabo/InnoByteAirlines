package hu.rszoft.tibi.innobyteairlines;

import hu.rszoft.tibi.innobyteairlines.service.AirlineService;
import hu.rszoft.tibi.innobyteairlines.service.XmlParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InnobyteairlinesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InnobyteairlinesApplication.class, args);


        XmlParser xmlParser = new XmlParser();
        System.out.println(xmlParser.readCities());
        System.out.println(xmlParser.readAirlines());
        System.out.println(xmlParser.readFlights());


        AirlineService airlineService = new AirlineService();
        System.out.println("Flights by airline id: 1");
        System.out.println(airlineService.getAllFlightsByAirlineId("1"));
    }

}
