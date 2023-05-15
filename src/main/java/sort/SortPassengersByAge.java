package sort;

import transport.Passenger;

import java.util.ArrayList;

public class SortPassengersByAge extends SortPassengersByParameters {
    @Override
    public void sort(ArrayList<Passenger> passengers) {
        int n = passengers.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (passengers.get(j - 1).age() > passengers.get(j).age()) {
                    swap(passengers, j - 1, j);
                }
            }
        }
    }
}