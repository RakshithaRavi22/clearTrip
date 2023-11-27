package exception;

import repository.FlightRepository;

public class FLightNotFoundException extends RuntimeException{

    public FLightNotFoundException(String message){
        super(message);
    }

}
