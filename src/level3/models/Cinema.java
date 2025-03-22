package level3.models;

import level3.services.CinemaManagement;
import level3.services.SeatManagement;
import level3.utils.KeyboardInput;

public class Cinema {
    private int numberOfRows;
    private int seatsPerRow;
    private SeatManagement seatManagement;
    private CinemaManagement cinemaManagement;

    public Cinema() {
        requestInitialData();
        this.seatManagement = new SeatManagement();
        this.cinemaManagement = new CinemaManagement(this);
    }

    public CinemaManagement getCinemaManagement() {
        return this.cinemaManagement;
    }

    public SeatManagement getSeatManagement() {
        return seatManagement;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void requestInitialData() {
        this.numberOfRows = KeyboardInput.readInteger("Cuantas filas tiene el cine? ");
        this.seatsPerRow = KeyboardInput.readInteger("Cuantas butacas por fila tiene el cine? ");
        System.out.println(
                "Cine con creado: " + this.numberOfRows + " filas y " + this.seatsPerRow + " butacas por fila"
        );
    }

}
