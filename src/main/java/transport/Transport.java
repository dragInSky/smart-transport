package transport;

import sort.ISortPassengers;

import java.util.ArrayList;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Transport {
    private final int size;
    ISortPassengers sorter;
    Passenger[] passengers;
    private final ArrayList<Station> stations;

    Transport(int size, ISortPassengers sorter, ArrayList<Station> stations) {
        this.size = size;
        this.sorter = sorter;
        passengers = new Passenger[size];
        for (int i = 0; i < size; i++) {
            passengers[i] = null;
        }
        this.stations = stations;
    }

    public void run() {

    }

    private void load() {

    }

    private void unload() {

    }
}
