package sort;

import transport.Passenger;

abstract public class SortPassengersByParameters implements ISortPassengers{
    protected void swap(Passenger[] passengers, int indexFirstPassenger, int indexSecondPassenger){
        Passenger temp = passengers[indexFirstPassenger];
        passengers[indexFirstPassenger] = passengers[indexSecondPassenger];
        passengers[indexSecondPassenger] = temp;
    }
}
