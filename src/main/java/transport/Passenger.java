package transport;

public class Passenger {
    private final int id;
    private final int age;
    private final Station start;
    private final Station finish;

    public Passenger(int id, int age, Station start, Station finish) {
        this.id = id;
        this.age = age;
        this.start = start;
        this.finish = finish;
    }

    public Station getFinish() {
        return finish;
    }
}
