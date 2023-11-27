package service;

import enums.FareType;
import model.Fare;
import model.Flight;

import java.util.List;
import java.util.Map;

public interface FlightService {

    Map<Integer, Flight> searchFlight(String departureFrom, String arrivalTo, int departureDate, int pax);

    void bookFlight(int userId, int flightNo, int departureDate, FareType fareType, List<String> seats);

}
