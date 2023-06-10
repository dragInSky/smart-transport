package transport;

public class Seat {
    public SeatType type;
    public boolean is_empty;
    public int id;

    public Seat(SeatType type, boolean is_empty, int id) {
        this.type = type;
        this.is_empty = is_empty;
        this.id = id;
    }
}
