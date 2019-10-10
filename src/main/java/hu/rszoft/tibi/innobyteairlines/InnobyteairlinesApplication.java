package hu.rszoft.tibi.innobyteairlines;

import hu.rszoft.tibi.innobyteairlines.service.XmlParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class InnobyteairlinesApplication {

    public static void main(String[] args) {
        SpringApplication.run(InnobyteairlinesApplication.class, args);
        XmlParser xmlParser = new XmlParser();
        try {
            System.out.println(xmlParser.readCities());
            System.out.println(xmlParser.readAirlines());
            System.out.println(xmlParser.readFlights());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
