package repository;

import exception.FLightNotFoundException;
import model.Flight;

import java.util.HashMap;
import java.util.Map;

public class FlightRepository {

    Map<Integer, Flight> flightMap = new HashMap<>();

    public void addFlight(Flight flight){
        flightMap.put(flight.getFlightNo(), flight);
    }

    public Map<Integer, Flight> getAllFlights(){
        return flightMap;
    }


    public Flight getFlightById(int flightNo){
        if(!flightMap.containsKey(flightNo)){
            throw new FLightNotFoundException("Flight not found");
        }

        return flightMap.get(flightNo);

    }

}
