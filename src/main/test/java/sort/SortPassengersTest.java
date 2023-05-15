package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import transport.Passenger;

import java.util.ArrayList;

class SortPassengersTest {
    private ISortPassengers sorterByAge;
    private ISortPassengers sorterByFinishStation;
    private ArrayList<Passenger> passengers;

    @BeforeEach
    public void setUp() {
        sorterByAge = new SortPassengersByAge();
        sorterByFinishStation = new SortPassengersByFinishStation();

        passengers = new ArrayList<>();

        passengers.add(new Passenger(18, 1, 4));
        passengers.add(new Passenger(10, 1, 2));
        passengers.add(new Passenger(20, 1, 3));
    }

    @Test
    void sortByAgeTest() {
        ArrayList<Passenger> expectedPassengersForAgesSort = new ArrayList<>();
        expectedPassengersForAgesSort.add(new Passenger(10, 1, 2));
        expectedPassengersForAgesSort.add(new Passenger(18, 1, 4));
        expectedPassengersForAgesSort.add(new Passenger(20, 1, 3));

        sorterByAge.sort(passengers);
        Assertions.assertEquals(expectedPassengersForAgesSort, passengers, "Sorting by age failed");
    }

    @Test
    void sortByFinishStation() {
        ArrayList<Passenger> expectedPassengersForFinishStationSort = new ArrayList<>();
        expectedPassengersForFinishStationSort.add(new Passenger(10, 1, 2));
        expectedPassengersForFinishStationSort.add(new Passenger(20, 1, 3));
        expectedPassengersForFinishStationSort.add(new Passenger(18, 1, 4));

        sorterByFinishStation.sort(passengers);
        Assertions.assertEquals(expectedPassengersForFinishStationSort, passengers, "Sorting by finish station failed");
    }
}