package transport;

import sort.ISortPassengers;
import sort.SortPassengersByAge;
import sort.SortPassengersByFinishStation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Transport {
    private final int numberOfSeats = 11;
    ISortPassengers sorter;
    Passenger[] passengers = new Passenger[numberOfSeats];
    private final HashMap<String, Integer> route;
    private final ArrayList<Station> stations;

    public Transport(HashMap<String, Integer> route, ArrayList<Station> stations) {
        sorter = new SortPassengersByAge();
        for (int i = 0; i < stations.size(); i++) {
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
            prettyPrint(station);
        }
    }

    private void prettyPrint(Station station) {
        int count = 1;
        System.out.println("\tПассажиры на остановке " + station.getName() + ":");
        for (Passenger passenger : passengers) {
            if (passenger != null) {
                System.out.print(count++ + ". (" + passenger.age() +
                        ", " + passenger.startStationName() +
                        ", " + passenger.finishStationName() + ")\t");
            } else {
                System.out.print(count++ + ". " + "Free\t");
            }
        }
        System.out.println();
    }

    private void unload(Station station) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && Objects.equals(passengers[i].finishStationName(), station.getName())) {
                passengers[i] = null;
            }
        }
    }

    private void load(Station station) {
        if (station.getPassengers() == null) {
            return;
        }
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

    public HashMap<String, Integer> getRoute() {
        return route;
    }
}
