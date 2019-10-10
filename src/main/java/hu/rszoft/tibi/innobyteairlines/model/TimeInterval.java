package hu.rszoft.tibi.innobyteairlines.model;

import java.util.Date;

public class TimeInterval {
    public long startTime;
    public long endTime;

    public TimeInterval(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return new Date(startTime) + " - " + new Date(endTime);
    }
}
