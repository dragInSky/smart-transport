import sort.SortPassengersByFinishStation;
import transport.Passenger;
import transport.Station;
import transport.Transport;
import util.Route;

import java.util.ArrayList;
import java.util.List;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Station> stations = new Main().generateStations();

        Transport transport = new Transport(stations, new SortPassengersByFinishStation());

        transport.run();
    }

    public ArrayList<Station> generateStations() {
        ArrayList<Station> stations = new ArrayList<>();

        {
            ArrayList<Passenger> passengers = (ArrayList<Passenger>) List.of(
                    new Passenger(16, 1, 3),
                    new Passenger(51, 1, 2),
                    new Passenger(16, 1, 2),
                    new Passenger(12, 1, 4),
                    new Passenger(12, 1, 2),
                    new Passenger(12, 1, 3),
                    new Passenger(48, 1, 3)
            );

            stations.add(new Station(Route.route.get(1), 1, passengers));
        }

        {
            ArrayList<Passenger> passengers = (ArrayList<Passenger>) List.of(
                    new Passenger(21, 2, 3),
                    new Passenger(20, 2, 4),
                    new Passenger(21, 2, 3)
            );

            stations.add(new Station(Route.route.get(2), 2, passengers));
        }

        stations.add(new Station(Route.route.get(3), 3,
                (ArrayList<Passenger>) List.of(new Passenger(99, 3, 4)))
        );

        stations.add(new Station(Route.route.get(4), 4, null));

        return stations;
    }
}