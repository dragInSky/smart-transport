package transport;

import java.util.ArrayList;

public class ComponentGenerator {
    private static final int lieSeatNumber = 2;
    private static final int sitSeatNumber = 3;
    private static final int staySeatNumber = 2;

    public static ArrayList<Seat> generateSeatsConfiguration() {
        ArrayList<Seat> seatsConfiguration = new ArrayList<>();

        int id = 1;

        for (int i = 0; i < lieSeatNumber; i++) {
            seatsConfiguration.add(new Seat(SeatType.LIE_SEAT, true, id++));
        }

        for (int i = 0; i < sitSeatNumber; i++) {
            seatsConfiguration.add(new Seat(SeatType.SIT_SEAT, true, id++));
        }

        for (int i = 0; i < staySeatNumber; i++) {
            seatsConfiguration.add(new Seat(SeatType.STAY_SEAT, true, id++));
        }

        return seatsConfiguration;
    }

    public static ArrayList<Station> generateStations() {
        ArrayList<Station> stations = new ArrayList<>();

        {
            ArrayList<Passenger> passengers = new ArrayList<>() {
                {
                    add(new Passenger(16, 1, 3));
                    add(new Passenger(51, 1, 2));
                    add(new Passenger(16, 1, 2));
                    add(new Passenger(12, 1, 4));
                    add(new Passenger(12, 1, 2));
                    add(new Passenger(12, 1, 3));
                    add(new Passenger(48, 1, 3));
                }
            };

            stations.add(new Station(1, passengers));
        }

        {
            ArrayList<Passenger> passengers = new ArrayList<>() {
                {
                    add(new Passenger(21, 2, 3));
                    add(new Passenger(20, 2, 4));
                    add(new Passenger(21, 2, 3));
                }
            };

            stations.add(new Station(2, passengers));
        }


        {
            ArrayList<Passenger> passengers = new ArrayList<>();
            passengers.add(new Passenger(99, 3, 4));

            stations.add(new Station(3, passengers));
        }

        stations.add(new Station(4, null));

        return stations;
    }
}
