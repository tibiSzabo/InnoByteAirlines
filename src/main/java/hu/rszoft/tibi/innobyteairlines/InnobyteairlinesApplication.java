package hu.rszoft.tibi.innobyteairlines;

import hu.rszoft.tibi.innobyteairlines.model.City;
import hu.rszoft.tibi.innobyteairlines.service.AirlineService;
import hu.rszoft.tibi.innobyteairlines.service.CityService;
import hu.rszoft.tibi.innobyteairlines.service.FlightService;
import hu.rszoft.tibi.innobyteairlines.service.XmlParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InnobyteairlinesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InnobyteairlinesApplication.class, args);

        XmlParser xmlParser = new XmlParser();
        AirlineService airlineService = new AirlineService();
        CityService cityService = new CityService();
        FlightService flightService = new FlightService();

        City smallestCity = cityService.getSmallestCity();
        City biggestCity = cityService.getBiggestCity();

        System.out.println("\n");
        System.out.println("Legkisebb város: " + smallestCity.getName() + ", " + smallestCity.getPopulation());
        System.out.println("Legnagyobb város: " + biggestCity.getName() + ", " + biggestCity.getPopulation());
        System.out.println("\n");

        System.out.println(airlineService.getShortestDistanceUsingOneAirline(smallestCity.getId(), biggestCity.getId()));
    }

}
