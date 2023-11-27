package model;

import enums.FareType;

import java.util.List;

public class Fare {

    private FareType fareType;

    private List<Seat> seats;

    private double cost;

    public Fare(FareType fareType, List<Seat> seats, double cost) {
        this.fareType = fareType;
        this.seats = seats;
        this.cost = cost;
    }

    public FareType getFareType() {
        return fareType;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setFareType(FareType fareType) {
        this.fareType = fareType;
    }

    public FareType getFareId() {
        return fareType;
    }

    public void setFareId(FareType fareType) {
        this.fareType = fareType;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
