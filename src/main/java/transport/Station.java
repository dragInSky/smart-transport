package transport;

import java.util.ArrayList;

/**
 * @author draginsky
 * @since 14.05.2023
 */
public record Station(int number, ArrayList<Passenger> passengers) {
}
