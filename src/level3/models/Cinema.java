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
        this.numberOfRows = KeyboardInput.readIntegerBetweenOnRange("Cuantas filas tiene el cine? ", 1, 999);
        this.seatsPerRow = KeyboardInput.readIntegerBetweenOnRange("Cuantas butacas por fila tiene el cine? ", 1, 999);
        System.out.println(
                "Cine con creado: " + this.numberOfRows + " filas y " + this.seatsPerRow + " butacas por fila"
        );
    }

}
