package transport;

class Passenger {
    private final int age, startStationNum, finishStationNum;
    public Seat seat;


    public int getAge() {
        return age;
    }

    public int getStartStationNum() {
        return startStationNum;
    }

    public int getFinishStationNum() {
        return finishStationNum;
    }

    public Passenger(int age, int startStationNum, int finishStationNum) {
        this.age = age;
        this.startStationNum = startStationNum;
        this.finishStationNum = finishStationNum;
    }
}
