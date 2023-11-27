package model;

import enums.SeatStatus;

public class Seat {

    private String seatNo;

    private SeatStatus seatStatus;

    public Seat(String seatNo, SeatStatus seatStatus) {
        this.seatNo = seatNo;
        this.seatStatus = seatStatus;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
