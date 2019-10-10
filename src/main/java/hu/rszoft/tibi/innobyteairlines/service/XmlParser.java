package hu.rszoft.tibi.innobyteairlines.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import hu.rszoft.tibi.innobyteairlines.model.Airlines;
import hu.rszoft.tibi.innobyteairlines.model.Cities;
import hu.rszoft.tibi.innobyteairlines.model.Flights;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlParser {
    private XmlMapper xmlMapper = new XmlMapper();

    public Airlines readAirlines() throws IOException {
        String parsedXml = new String(Files.readAllBytes(Paths.get("airlines.xml")));
        return this.xmlMapper.readValue(parsedXml, Airlines.class);
    }

    public Cities readCities() throws IOException {
        String parsedXml = new String(Files.readAllBytes(Paths.get("cities.xml")));
        return this.xmlMapper.readValue(parsedXml, Cities.class);
    }

    public Flights readFlights() throws IOException {
        String parsedXml = new String(Files.readAllBytes(Paths.get("flights.xml")));
        return this.xmlMapper.readValue(parsedXml, Flights.class);
    }


}
