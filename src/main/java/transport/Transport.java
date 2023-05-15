package transport;

import sort.ISortPassengers;
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
    ArrayList<Passenger> passengers = new ArrayList<>();
    private final HashMap<String, Integer> route;
    private final ArrayList<Station> stations;

    public Transport(HashMap<String, Integer> route, ArrayList<Station> stations) {
        //TODO
        sorter = new SortPassengersByFinishStation(route);
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
        System.out.println("\tПассажиры на остановке " + station.name() + ":");
        for (Passenger passenger : passengers) {
            System.out.print(count++ + ". (" + passenger.age() +
                    ", " + passenger.startStationName() +
                    ", " + passenger.finishStationName() + ")\t");
        }
        System.out.println("Свободных мест осталось: " + (numberOfSeats - passengers.size()));
    }

    private void unload(Station station) {
        ArrayList<Passenger> outComingPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (Objects.equals(passenger.finishStationName(), station.name())) {
                outComingPassengers.add(passenger);
            }
        }
        passengers.removeAll(outComingPassengers);
    }

    private void load(Station station) {
        if (station.passengers() == null) {
            return;
        }
        for (Passenger passenger : station.passengers()) {
            if (passengers.size() < numberOfSeats) {
                passengers.add(passenger);
            } else {
                return;
            }
        }
    }

    public HashMap<String, Integer> getRoute() {
        return route;
    }
}
