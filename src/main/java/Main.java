import sort.SortPassengersByFinishStation;
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
        int station1 = 1;
        int station2 = 2;
        int station3 = 3;
        int station4 = 4;

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

            stations.add(new Station("Контур", station1, passengers1));
        }

        {
            ArrayList<Passenger> passengers2 = new ArrayList<>();
            passengers2.add(new Passenger(21, station2, station3));
            passengers2.add(new Passenger(20, station2, station4));
            passengers2.add(new Passenger(21, station2, station3));

            stations.add(new Station("Митина", station2, passengers2));
        }

        {
            ArrayList<Passenger> passengers3 = new ArrayList<>();
            passengers3.add(new Passenger(99, station3, station4));

            stations.add(new Station("Моя", station3, passengers3));
        }

        stations.add(new Station("Маша", station4, null));

        Transport transport = new Transport(stations, new SortPassengersByFinishStation());

        transport.run();
    }
}