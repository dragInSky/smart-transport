package sort;

import transport.Passenger;

public class SortPassengersByAge extends SortPassengersByParameters {
    @Override
    public void sort(Passenger[] passengers) {
        int n = passengers.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (passengers[j - 1] != null && passengers[j] != null &&
                        passengers[j - 1].age() > passengers[j].age()) {
                    swap(passengers, j - 1, j);
                }
            }
        }
    }
}
