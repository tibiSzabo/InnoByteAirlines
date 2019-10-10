package hu.rszoft.tibi.innobyteairlines.model;

public enum XmlDatabaseEntityName {
    CITY ("city"),
    AIRLINE ("airline"),
    FLIGHT ("flight");

    private final String stringValue;

    XmlDatabaseEntityName(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
