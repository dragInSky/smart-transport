package sort;

import transport.Passenger;

import java.util.HashMap;

public class SortPassengersByFinishStation extends SortPassengersByParameters {
    HashMap<String, Integer> route;
    public SortPassengersByFinishStation(HashMap<String, Integer> route){
        this.route = route;
    }
    @Override
    public void sort(Passenger[] passengers) {
        int n = passengers.length;
        for (int i = 0; i < n; i++){
            for (int j = 1; j < n - i; j++){
                int firstPassengerStationNumber = route.get(passengers[j - 1].finishStationName());
                int secondPassengerStationNumber = route.get(passengers[j].finishStationName());
                if (firstPassengerStationNumber > secondPassengerStationNumber) {
                    swap(passengers, j - 1, j);
                }
            }
        }
    }
}
