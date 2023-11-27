package model;

public class Booking {

    private int userId;

    private int flightNo;

    private double totalAmount;

    public Booking(int userId, int flightNo, double totalAmount) {
        this.userId = userId;
        this.flightNo = flightNo;
        this.totalAmount = totalAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
