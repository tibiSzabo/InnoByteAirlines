package hu.rszoft.tibi.innobyteairlines.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hu.rszoft.tibi.innobyteairlines.model.Airlines;
import hu.rszoft.tibi.innobyteairlines.model.Cities;
import hu.rszoft.tibi.innobyteairlines.model.Flights;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Service
public class XmlParser {

    private XmlMapper xmlMapper = new XmlMapper();

    public Airlines readAirlines() throws IOException {
        File file = new File("src/main/resources/data/airlines.xml");
        String parsedXml = new String(Files.readAllBytes(file.toPath()));
        return this.xmlMapper.readValue(parsedXml, Airlines.class);
    }

    public Cities readCities() throws IOException {
        File file = new File("src/main/resources/data/cities.xml");
        String parsedXml = new String(Files.readAllBytes(file.toPath()));
        return this.xmlMapper.readValue(parsedXml, Cities.class);
    }

    public Flights readFlights() throws IOException {
        File file = new File("src/main/resources/data/flights.xml");
        String parsedXml = new String(Files.readAllBytes(file.toPath()));
        return this.xmlMapper.readValue(parsedXml, Flights.class);
    }


}
