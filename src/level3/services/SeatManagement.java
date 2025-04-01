package level3.services;

import level3.exceptions.FreeSeatException;
import level3.exceptions.SeatOccupiedException;
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

    public int findCinemaSeatWithPerson(int row, int seatNumber, String person) {
        int i = 0;
        CinemaSeat seatObj = new CinemaSeat(row, seatNumber, person);
        while (i < this.cinemaSeats.size()) {
            if (cinemaSeats.get(i).equals(seatObj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void checkOccupiedSeat(int indexCinemaSeat) {
        if (indexCinemaSeat != -1) {
            throw new SeatOccupiedException("la butaca está ocupada, no se puede reservar");
        }
    }

    public void addCinemaSeat(CinemaSeat cinemaSeat) {
        String person = cinemaSeat.getPerson();
        int row = cinemaSeat.getRow();
        int seatNumber = cinemaSeat.getSeatNumber();
        int indexCinemaSeat = findCinemaSeatWithPerson(row, seatNumber, person);
        try {
            checkOccupiedSeat(indexCinemaSeat);
            this.cinemaSeats.add(cinemaSeat);
            System.out.println("Reserva: " + cinemaSeat + ", realizada con éxito");
        } catch (SeatOccupiedException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    private void checkFreeSeat(int indexCinemaSeat) {
        if (indexCinemaSeat == -1) {
            throw new FreeSeatException("la butaca está libre, no se puede eliminar reserva");
        }
    }

    public void removeCinemaSeat(int row, int seatNumber, String person) {
        int indexCinemaSeat = findCinemaSeatWithPerson(row, seatNumber, person);
        try {
            checkFreeSeat(indexCinemaSeat);
            System.out.println("Reserva: " + this.cinemaSeats.get(indexCinemaSeat) + ", eliminada");
            this.cinemaSeats.remove(indexCinemaSeat);
        } catch (FreeSeatException e) {
            System.out.println("Error, " + e.getMessage());
        }
    }

    public int findCinemaSeat(int row, int seatNumber) {
        int i = 0;
        while (i < this.cinemaSeats.size()) {
            if (this.cinemaSeats.get(i).equalsSeat(row, seatNumber)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
