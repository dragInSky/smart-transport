package transport;

import java.util.ArrayList;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Station {
    private final String name;
    private final int number;
    private final boolean isStart, isFinish;
    private final ArrayList<Passenger> passengers;

    Station(String name, int number, boolean isStart, boolean isFinish, ArrayList<Passenger> passengers) {
        this.name = name;
        this.number = number;
        this.isStart = isStart;
        this.isFinish = isFinish;
        this.passengers = passengers;
    }
}
