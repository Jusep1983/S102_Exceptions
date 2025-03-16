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
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            switch (this.cinemaManagement.menu()) {
                case 1:
                    this.cinemaManagement.showCinemaSeats();
                    break;
                case 2:
                    this.cinemaManagement.showCinemaSeatByPerson();
                    break;
                case 3:
                    this.cinemaManagement.reserveCinemaSeat();
                    break;
                case 4:
                    this.cinemaManagement.cancelReservation();
                    break;
                case 5:
                    this.cinemaManagement.cancelReservationByPerson();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    exit = true;
                    break;
            }
        }

    }

}

