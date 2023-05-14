package transport;

import sort.ISortPassengers;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Transport {
    ISortPassengers sorter;
    Passenger[] passengers;
    private final ArrayList<String> route;
    private final ArrayList<Station> stations;

    Transport(int size, ISortPassengers sorter, ArrayList<String> route, ArrayList<Station> stations) {
        this.sorter = sorter;
        passengers = new Passenger[size];
        for (int i = 0; i < size; i++) {
            passengers[i] = null;
        }
        this.route = route;
        this.stations = stations;
    }

    public void run() {
        for (Station station : stations) {
            unload(station);
            load(station);
            sorter.sort(passengers);
        }
    }

    private void unload(Station station) {
        for (int i = 0; i < passengers.length; i++) {
            if (Objects.equals(passengers[i].finishStationName(), station.getName())) {
                passengers[i] = null;
            }
        }
    }

    private void load(Station station) {
        for (Passenger passenger : station.getPassengers()) {
            if (isFreeSpace()) {
                add(passenger);
            } else {
                return;
            }
        }
    }

    private boolean isFreeSpace() {
        for (Passenger passenger : passengers) {
            if (passenger == null) {
                return true;
            }
        }
        return false;
    }

    private void add(Passenger passenger) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = passenger;
                break;
            }
        }
    }

    public ArrayList<String> getRoute() {
        return route;
    }
}
