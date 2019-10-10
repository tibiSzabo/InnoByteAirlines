package hu.rszoft.tibi.innobyteairlines.model;

public class City {
    private String id;
    private String name;
    private int population;

    public City(String id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
