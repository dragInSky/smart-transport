package ui;

import transport.Passenger;
import transport.Station;

import java.util.ArrayList;

/**
 * @author draginsky
 * @since 15.05.2023
 */
public class ConsolePrint {
    public static void prettyPrint(Station station, ArrayList<Passenger> passengers, int numberOfSeats) {
        int count = 1;
        System.out.println("\tПассажиры на остановке " + station.name() + ":");
        for (Passenger passenger : passengers) {
            System.out.print(count++ + ". (age: " + passenger.age() +
                    ", start: " + passenger.startStationNum() +
                    ", finish: " + passenger.finishStationNum() + ")\t");
        }
        System.out.println("Свободных мест осталось: " + (numberOfSeats - passengers.size()));
    }
}
