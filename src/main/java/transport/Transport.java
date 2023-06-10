package transport;

import sort.ISortPassengers;
import ui.ConsolePrint;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Transport {
    private final HashMap<Seat, Integer> seatTypeWithNumber = new HashMap<>();
    private final TransportSitter transportSitter;
    private final int numberOfSeats = 11;
    private final int numberOfStaySeats = 5;
    private final int numberOfSitSeats = 4;
    private final int numberOfLieSeats = 2;
    private final ArrayList<Passenger> passengers = new ArrayList<>();
    private final ArrayList<Station> stations;

    public Transport(ArrayList<Station> stations, TransportSitter transportSitter) {
        seatTypeWithNumber.put(Seat.LIE_SEAT, numberOfLieSeats);
        seatTypeWithNumber.put(Seat.SIT_SEAT, numberOfSitSeats);
        seatTypeWithNumber.put(Seat.STAY_SEAT, numberOfStaySeats);

        this.stations = stations;
        this.transportSitter = transportSitter;
    }

    public void run() {
        ConsolePrint.routePrint();
        for (Station station : stations) {
            unload(station);
            load(station);
            transportSitter.arrangement(passengers, seatTypeWithNumber);
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
