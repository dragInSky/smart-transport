package transport;

import java.util.ArrayList;

public class ComponentGenerator {

    public static ArrayList<Seat> generateSeatsConfiguration() {
        ArrayList<Seat> seatsConfiguration = new ArrayList<>();
        seatsConfiguration.add(new Seat(SeatType.LIE_SEAT, true, 1));
        seatsConfiguration.add(new Seat(SeatType.LIE_SEAT, true, 2));
        seatsConfiguration.add(new Seat(SeatType.SIT_SEAT, true, 3));
        seatsConfiguration.add(new Seat(SeatType.SIT_SEAT, true, 4));
        seatsConfiguration.add(new Seat(SeatType.SIT_SEAT, true, 5));
        seatsConfiguration.add(new Seat(SeatType.STAY_SEAT, true, 6));
        seatsConfiguration.add(new Seat(SeatType.STAY_SEAT, true, 7));
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
