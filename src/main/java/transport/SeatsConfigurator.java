package transport;

import java.util.ArrayList;

public class SeatsConfigurator {
    public static ArrayList<Seat> getTypeSeats(ArrayList<Seat> seatsConfiguration, SeatType seatType) {
        ArrayList<Seat> seatsByType = new ArrayList<>();
        for (Seat seat : seatsConfiguration) {
            if (seat.type == seatType) {
                seatsByType.add(seat);
            }
        }
        return seatsByType;
    }

}
