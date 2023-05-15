//package sort;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import transport.Passenger;
//
//import java.util.HashMap;
//
//class SortPassengersTest {
//    private ISortPassengers sorterByAge;
//    private ISortPassengers sorterByFinishStation;
//    private final HashMap<String, Integer> route = new HashMap<>();
//    private Passenger[] passengers;
//
//    @BeforeEach
//    public void setUp() {
//        route.put("Lenina", 1);
//        route.put("Popova", 2);
//        route.put("Chapaeva", 4);
//        route.put("Furmanova", 3);
//
//        sorterByAge = new SortPassengersByAge();
//        sorterByFinishStation = new SortPassengersByFinishStation(route);
//
//        passengers =
//            new Passenger[]
//            {
//                new Passenger(18, "Lenina", "Chapaeva"),
//                new Passenger(10, "Lenina", "Popova"),
//                new Passenger(20, "Lenina", "Furmanova")
//            };
//    }
//
//    @Test
//    void sortByAgeTest() {
//        Passenger[] expectedPassengersForAgesSort =
//        {
//            new Passenger(10, "Lenina", "Popova"),
//            new Passenger(18, "Lenina", "Chapaeva"),
//            new Passenger(20, "Lenina", "Furmanova")
//        };
//
//        sorterByAge.sort(passengers);
//        Assertions.assertArrayEquals(expectedPassengersForAgesSort, passengers, "Sorting by age failed");
//    }
//
//    @Test
//    void sortByFinishStation() {
//        Passenger[] expectedPassengersForFinishStationSort = {
//                new Passenger(10, "Lenina", "Popova"),
//                new Passenger(20, "Lenina", "Furmanova"),
//                new Passenger(18, "Lenina", "Chapaeva"),
//        };
//
//        sorterByFinishStation.sort(passengers);
//        Assertions.assertArrayEquals(expectedPassengersForFinishStationSort, passengers, "Sorting by finish station failed");
//    }
//}