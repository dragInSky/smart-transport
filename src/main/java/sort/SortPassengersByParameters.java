package sort;

import transport.Passenger;

import java.util.ArrayList;

abstract public class SortPassengersByParameters implements ISortPassengers{
    protected void swap(ArrayList<Passenger> passengers, int indexFirstPassenger, int indexSecondPassenger){
        Passenger temp = passengers.get(indexFirstPassenger);
        passengers.set(indexFirstPassenger, passengers.get(indexSecondPassenger));
        passengers.set(indexSecondPassenger, temp);
    }
}
