package transport;

public class Passenger {
    private final int age;
    private final String startStationName;
    private final String finishStationName;

    public Passenger(int age, String startStationName, String finishStationName) {
        this.age = age;
        this.startStationName = startStationName;
        this.finishStationName = finishStationName;
    }

    public String getFinishStationName() {
        return finishStationName;
    }
}
