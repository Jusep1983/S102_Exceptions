package level3.services;

import level3.exceptions.ExceptionFreeSeat;
import level3.exceptions.ExceptionSeatOccupied;
import level3.models.CinemaSeat;

import java.util.ArrayList;

public class SeatManagement {
    private ArrayList<CinemaSeat> cinemaSeats;

    public SeatManagement() {
        this.cinemaSeats = new ArrayList<CinemaSeat>();
    }

    public ArrayList<CinemaSeat> getCinemaSeats() {
        return cinemaSeats;
    }

    public int findCinemaSeat(int row, int seatNumber) {
        int indexCinemaSeat = -1, i = 0;
        boolean found = false;
        while (i < this.cinemaSeats.size() && !found) {
            if ((row == cinemaSeats.get(i).getRow()) && (seatNumber == cinemaSeats.get(i).getSeatNumber())) {
                indexCinemaSeat = i;
                found = true;
            }
            i++;
        }
        return indexCinemaSeat;
    }

    public void addCinemaSeat(CinemaSeat cinemaSeat) {
        int row = cinemaSeat.getRow();
        int seatNumber = cinemaSeat.getSeatNumber();
        int indexCinemaSeat = findCinemaSeat(row, seatNumber);
        try {
            if (indexCinemaSeat != -1) {
                throw new ExceptionSeatOccupied("La butaca está ocupada");
            }
            this.cinemaSeats.add(cinemaSeat);
            System.out.println("Reserva " + cinemaSeat + " realizada con éxito");
        } catch (ExceptionSeatOccupied e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    public void removeCinemaSeat(int row, int seatNumber) {
        int indexCinemaSeat = findCinemaSeat(row, seatNumber);
        try {
            if (indexCinemaSeat == -1) {
                throw new ExceptionFreeSeat("La butaca está libre");
            }
            System.out.println("Reserva " + this.cinemaSeats.get(indexCinemaSeat) + " eliminada");
            this.cinemaSeats.remove(indexCinemaSeat);
        } catch (ExceptionFreeSeat e) {
            System.out.println("Error, " + e.getMessage());
        }
    }


}

