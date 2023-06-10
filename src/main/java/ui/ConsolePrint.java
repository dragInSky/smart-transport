package ui;

import sort.ISortPassengers;
import transport.Passenger;
import transport.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author draginsky
 * @since 15.05.2023
 */
public class ConsolePrint {
    private static final HashMap<Integer, String> route = new HashMap<>() {
        {
            put(1, "Контур");
            put(2, "Митина");
            put(3, "Моя");
            put(4, "Маша");
        }
    };

    public static void routePrint() {
        System.out.println("Маршрут:");
        for (Map.Entry<Integer, String> pair : route.entrySet()) {
            System.out.println(" - Станция \"" + pair.getValue() + "\" - №" + pair.getKey());
        }
        System.out.println();
    }

    public static void sortPrint(ISortPassengers sorterToExit, ISortPassengers sorterToSeats) {
        System.out.println("Сортировка к выходу: " + sorterToExit.getClass().getName());
        System.out.println("Сортировка по рассадке: " + sorterToSeats.getClass().getName());
        System.out.println();
    }

    public static void stationStatePrint(Station station, ArrayList<Passenger> passengers, int numberOfSeats) {
        int count = 1;
        System.out.println("Пассажиры на остановке \"" + route.get(station.number()) + "\":" +
                "\tСвободных мест: " + (numberOfSeats - passengers.size()));
        for (Passenger passenger : passengers) {
            System.out.println(count++ + ". <" + passenger.getAge() +
                    ", " + passenger.getStartStationNum() +
                    " - " + passenger.getFinishStationNum() +
                    ", " + passenger.seat.type + " [" + passenger.seat.id + "]" + ">\t");
        }
        System.out.println();
    }
}
