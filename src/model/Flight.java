package model;

import java.util.List;

public class Flight {

    private int flightNo;

    private String airline;


    private String departureFrom;

    private String arrivalTo;

    private int departureDate;

    private int departureTime;

    private int arrivalTime;

    private List<Fare> fares;



    public Flight(int flightNo, String airline, String departureFrom, String arrivalTo, int departureDate, int departureTime, int arrivalTime, List<Fare> fares) {
        this.flightNo = flightNo;
        this.airline = airline;
        this.departureFrom = departureFrom;
        this.arrivalTo = arrivalTo;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fares = fares;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public String getDepartureFrom() {
        return departureFrom;
    }

    public void setDepartureFrom(String departureFrom) {
        this.departureFrom = departureFrom;
    }

    public String getArrivalTo() {
        return arrivalTo;
    }

    public void setArrivalTo(String arrivalTo) {
        this.arrivalTo = arrivalTo;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(int departureDate) {
        this.departureDate = departureDate;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Fare> getFares() {
        return fares;
    }

    public void setFares(List<Fare> fares) {
        this.fares = fares;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

}
