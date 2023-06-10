package transport;

import sort.ISortPassengers;

import java.util.ArrayList;

public class TransportSitter {
    private final ISortPassengers sorterToExit;
    private final ISortPassengers sorterToSeats;

    public TransportSitter(ISortPassengers sorterToExit, ISortPassengers sorterToSeats) {
        this.sorterToExit = sorterToExit;
        this.sorterToSeats = sorterToSeats;
    }

    private void putInSeats(ArrayList<Passenger> passengers, ArrayList<Seat> seatsConfiguration) {
        sorterToSeats.sort(passengers);
        int j = 0;
        for (SeatType seatType : SeatType.values()) {
            ArrayList<Seat> seats = SeatsConfigurator.getTypeSeats(seatsConfiguration, seatType);
            for (int i = 0; i < seats.size() && j < passengers.size(); i++) {
                passengers.get(j).futureSeatType = seatType;
                j++;
            }
        }
    }

    private void sortToExit(ArrayList<Passenger> passengers, ArrayList<Seat> seatsConfiguration) {
        sorterToExit.sort(passengers);
        for (Passenger passenger : passengers) {
            for (Seat seat : seatsConfiguration){
                if (passenger.futureSeatType == seat.type && seat.is_empty) {
                    passenger.seat = seat;
                    passenger.seat.is_empty = false;
                    break;
                }
            }
        }
        // сортируем людей к выходу
        // Бежим по списку людей и для каждого чела бежим по списку мест
        // Смотрим на место, если его тип совпадает с типом чела и места свободно, то сажаем чела, делаем место занятым и break
        // если место занято или тип не совпадает, то идём по местам дальше
    }

    public void arrangement(ArrayList<Passenger> passengers, ArrayList<Seat> seatsConfiguration) {
        putInSeats(passengers, seatsConfiguration);  // Просто указали тип места на которое сядет каждый чел
        sortToExit(passengers, seatsConfiguration);
    }
}
