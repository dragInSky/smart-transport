package ui;

import transport.Passenger;
import transport.Station;
import util.Route;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author draginsky
 * @since 15.05.2023
 */
public class ConsolePrint {
    public static void routePrint() {
        System.out.println("Маршрут:");
        for (Map.Entry<Integer, String> pair : Route.route.entrySet()) {
            System.out.println(" - Станция \"" + pair.getValue() + "\" - №" + pair.getKey());
        }
        System.out.println();
    }

    public static void stationStatePrint(Station station, ArrayList<Passenger> passengers, int numberOfSeats) {
        int count = 1;
        System.out.println("Пассажиры на остановке \"" + Route.route.get(station.number()) + "\":" +
                "\tСвободных мест: " + (numberOfSeats - passengers.size()));
        for (Passenger passenger : passengers) {
            System.out.print(count++ + ". <age: " + passenger.age() +
                    ", from: " + passenger.startStationNum() +
                    ", to: " + passenger.finishStationNum() + ">\t");
        }
        System.out.println("\n");
    }
}
