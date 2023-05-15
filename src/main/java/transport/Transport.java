package transport;

import sort.ISortPassengers;
import java.util.ArrayList;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Transport {
    private final int numberOfSeats = 11;
    ISortPassengers sorter;
    ArrayList<Passenger> passengers = new ArrayList<>();
    private final ArrayList<Station> stations;

    public Transport(ArrayList<Station> stations, ISortPassengers sorter) {
        this.stations = stations;
        this.sorter = sorter;
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
            System.out.print(count++ + ". (age: " + passenger.age() +
                    ", start: " + passenger.startStationNum() +
                    ", finish: " + passenger.finishStationNum() + ")\t");
        }
        System.out.println("Свободных мест осталось: " + (numberOfSeats - passengers.size()));
    }

    private void unload(Station station) {
        ArrayList<Passenger> outComingPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            if (passenger.finishStationNum() == station.number()) {
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
}
