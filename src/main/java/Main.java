import transport.Passenger;
import transport.Station;
import transport.Transport;

import java.util.ArrayList;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Main {
    public static void main(String[] args) {
        new Main().action();
    }

    private void action() {
        String station1 = "Контур";
        String station2 = "Митина";
        String station3 = "Моя";
        String station4 = "Маша";

        ArrayList<Station> stations = new ArrayList<>();
        {
            ArrayList<Passenger> passengers1 = new ArrayList<>();
            passengers1.add(new Passenger(16, station1, station3));
            passengers1.add(new Passenger(51, station1, station2));
            passengers1.add(new Passenger(16, station1, station2));
            passengers1.add(new Passenger(12, station1, station4));
            passengers1.add(new Passenger(12, station1, station2));
            passengers1.add(new Passenger(12, station1, station3));
            passengers1.add(new Passenger(48, station1, station3));

            stations.add(new Station(station1, 1, true, false, passengers1));
        }

        {
            ArrayList<Passenger> passengers2 = new ArrayList<>();
            passengers2.add(new Passenger(21, station2, station3));
            passengers2.add(new Passenger(20, station2, station4));
            passengers2.add(new Passenger(21, station2, station3));

            stations.add(new Station(station2, 2, true, false, passengers2));
        }

        {
            ArrayList<Passenger> passengers3 = new ArrayList<>();
            passengers3.add(new Passenger(99, station3, station4));

            stations.add(new Station(station3, 3, true, false, passengers3));
        }

        stations.add(new Station(station4, 4, false, true, null));

        Transport transport = new Transport(this::sort, null, stations);

        transport.run();
    }

    private void sort(Passenger[] passengers) {}
}