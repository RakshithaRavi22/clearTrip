import enums.FareType;
import enums.SeatStatus;
import model.Fare;
import model.Flight;
import model.Seat;
import repository.FlightRepository;
import repository.UserRepository;
import service.impl.FlightServiceImpl;
import service.impl.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        FlightRepository flightRepository = new FlightRepository();

        UserRepository userRepository = new UserRepository();

        UserServiceImpl userService = new UserServiceImpl(userRepository);

        FlightServiceImpl flightService = new FlightServiceImpl(userRepository, flightRepository);

        Seat s1 = new Seat("1c", SeatStatus.AVAILABLE);
        Seat s2 = new Seat("2b", SeatStatus.AVAILABLE);
        Seat s3 = new Seat("4c", SeatStatus.AVAILABLE);



        Fare far1 = new Fare(FareType.F1, List.of(s1), 2000);
        Fare far2 = new Fare(FareType.F1, List.of(s2), 2500);
        Fare far3 = new Fare(FareType.F1, List.of(s3), 2800);

        Flight f1 = new Flight(123, "6E", "DEL", "BEN", 28, 12, 2, List.of(far1, far2, far3));
        flightRepository.addFlight(f1);

        while(true){

            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            switch(command){
                case "ADD_USER" : userService.addUser(scanner.nextInt(), scanner.next(), scanner.nextDouble());
                                    break;

                case "SEARCH_FLIGHT" : flightService.searchFlight(scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt());
                break;

                case "BOOK_FLIGHT" : flightService.bookFlight(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), FareType.valueOf(scanner.next()), List.of(scanner.next()));
                break;

                default : System.exit(0);

            }


        }

    }
}