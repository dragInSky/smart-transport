import sort.SortPassengersByAge;
import sort.SortPassengersByFinishStation;
import transport.*;

import java.util.ArrayList;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Station> stations = ComponentGenerator.generateStations();
        ArrayList<Seat> seatsConfiguration = ComponentGenerator.generateSeatsConfiguration();
        Transport transport = new Transport(stations, new TransportSitter(
                new SortPassengersByFinishStation(), new SortPassengersByAge()
        ), seatsConfiguration);

        transport.run();
    }
}