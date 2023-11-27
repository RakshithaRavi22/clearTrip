package service.impl;

import enums.FareType;
import enums.SeatStatus;
import exception.InsufficientFundsException;
import exception.SeatsNotAvailableException;
import model.Booking;
import model.Flight;
import model.User;
import repository.FlightRepository;
import repository.UserRepository;
import service.FlightService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class FlightServiceImpl implements FlightService {


     UserRepository userRepository;

     FlightRepository flightRepository;

     Map<Integer, Booking> bookingMap = new HashMap<>();
     Integer bookingIndex =0;


    public FlightServiceImpl(UserRepository userRepository, FlightRepository flightRepository) {
        this.userRepository = userRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public Map<Integer, Flight> searchFlight(String departureFrom, String arrivalTo, int departureDate, int pax) {
        Map<Integer, Flight> availableFlights = new HashMap<>();

        var flightMap = flightRepository.getAllFlights();

        for(Map.Entry<Integer, Flight> flight: flightMap.entrySet()) {

            var currenFlight = flight.getValue();

            if(currenFlight.getDepartureDate() == departureDate
                        && currenFlight.getDepartureFrom().equals(departureFrom)
                        && currenFlight.getArrivalTo().equals(arrivalTo)) {

                AtomicLong noOfAvailableSeats = new AtomicLong();
                    currenFlight.getFares().stream().map(f -> {
                        var seats = f.getSeats();

                        noOfAvailableSeats.addAndGet(seats.stream().map(seat -> seat.getSeatStatus().equals(SeatStatus.AVAILABLE)).count());
                        return null;
                    });

                    if(noOfAvailableSeats.get() < pax){
                        throw new SeatsNotAvailableException("No of seats available for required pax not available. Please choose a different date or departure");
                    }

                    //adding flight details to list if conditions match
                    availableFlights.put(currenFlight.getFlightNo(), flight.getValue());
            }

        }

        return availableFlights;

    }

    @Override
    public void bookFlight(int userId, int flightNo, int departureDate, FareType fareType, List<String> seats) {

        User user = userRepository.getUser(userId);

        Flight flight = flightRepository.getFlightById(flightNo);

        var availableFlightsForDate = searchFlight(flight.getDepartureFrom(), flight.getArrivalTo(), departureDate, seats.size());

        if(!availableFlightsForDate.containsKey(flightNo)){
            throw new SeatsNotAvailableException("Please check availability of flights");
        }

        AtomicReference<Double> totalFare = new AtomicReference<>((double) 0);

        flight.getFares().stream().map(f -> {
            var seatsInFare = f.getSeats();
            seatsInFare.stream().map(s -> {
                seats.stream().map(seat ->{
                    if(seat.equals(s.getSeatNo())){
                        totalFare.updateAndGet(v -> new Double((double) (v + f.getCost())));
                    }
                    return null;
                });
                return null;
            });
            return null;
        });

        if(user.getFunds() < totalFare.get()){
            throw new InsufficientFundsException("insufficient funds");
        }

        Booking newBooking = new Booking(user.getUserId(), flight.getFlightNo(), totalFare.get());

        bookingMap.put(bookingIndex, newBooking);
        bookingIndex++;

    }
}
