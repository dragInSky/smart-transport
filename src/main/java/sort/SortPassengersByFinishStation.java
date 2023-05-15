package sort;

import transport.Passenger;

import java.util.ArrayList;
import java.util.HashMap;

public class SortPassengersByFinishStation extends SortPassengersByParameters {
    HashMap<String, Integer> route;
    public SortPassengersByFinishStation(HashMap<String, Integer> route){
        this.route = route;
    }
    @Override
    public void sort(ArrayList<Passenger> passengers) {
        int n = passengers.size();
        for (int i = 0; i < n; i++){
            for (int j = 1; j < n - i; j++) {
                int firstPassengerStationNumber = route.get(passengers.get(j - 1).finishStationName());
                int secondPassengerStationNumber = route.get(passengers.get(j).finishStationName());
                if (firstPassengerStationNumber > secondPassengerStationNumber) {
                    swap(passengers, j - 1, j);
                }
            }
        }
    }
}