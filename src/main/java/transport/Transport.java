package transport;

import sort.ISortPassengers;
import ui.ConsolePrint;

import java.util.ArrayList;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Transport {
    private final int numberOfSeats = 11;
    private final ISortPassengers sorter;
    private final ArrayList<Passenger> passengers = new ArrayList<>();
    private final ArrayList<Station> stations;

    public Transport(ArrayList<Station> stations, ISortPassengers sorter) {
        this.stations = stations;
        this.sorter = sorter;
    }

    public void run() {
        ConsolePrint.routePrint();
        for (Station station : stations) {
            unload(station);
            load(station);
            sorter.sort(passengers);
            ConsolePrint.stationStatePrint(station, passengers, numberOfSeats);
        }
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
