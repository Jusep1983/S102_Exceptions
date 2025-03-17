package level3.services;

import level3.exceptions.ExceptionFreeSeat;
import level3.exceptions.ExceptionSeatOccupied;
import level3.models.CinemaSeat;

import java.util.ArrayList;

public class SeatManagement {
    private ArrayList<CinemaSeat> cinemaSeats;

    public SeatManagement() {
        this.cinemaSeats = new ArrayList<>();
    }

    public ArrayList<CinemaSeat> getCinemaSeats() {
        return cinemaSeats;
    }

    public int findCinemaSeat(int row, int seatNumber, String person) {
        int indexCinemaSeat = -1, i = 0;
        boolean found = false;
        CinemaSeat seat = new CinemaSeat(row, seatNumber, person);
        while (i < this.cinemaSeats.size() && !found) {
            if (cinemaSeats.get(i).equals(seat)) {
                indexCinemaSeat = i;
                found = true;
            }
            i++;
        }
        return indexCinemaSeat;
    }

    public void addCinemaSeat(CinemaSeat cinemaSeat) {
        String person = cinemaSeat.getPerson();
        int row = cinemaSeat.getRow();
        int seatNumber = cinemaSeat.getSeatNumber();
        int indexCinemaSeat = findCinemaSeat(row, seatNumber, person);
        try {
            if (indexCinemaSeat != -1) {
                throw new ExceptionSeatOccupied("La butaca está ocupada");
            }
            this.cinemaSeats.add(cinemaSeat);
            System.out.println("Reserva: " + cinemaSeat + ", realizada con éxito");
        } catch (ExceptionSeatOccupied e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    public void removeCinemaSeat(int row, int seatNumber, String person) {
        int indexCinemaSeat = findCinemaSeat(row, seatNumber, person);
        try {
            if (indexCinemaSeat == -1) {
                throw new ExceptionFreeSeat("La butaca está libre");
            }
            System.out.println("Reserva: " + this.cinemaSeats.get(indexCinemaSeat) + ", eliminada");
            this.cinemaSeats.remove(indexCinemaSeat);
        } catch (ExceptionFreeSeat e) {
            System.out.println("Error, " + e.getMessage());
        }
    }


}

