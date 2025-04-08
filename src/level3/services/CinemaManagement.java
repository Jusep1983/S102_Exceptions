package level3.services;

import level3.exceptions.IncorrectSeatException;
import level3.exceptions.InvalidRowException;
import level3.models.Cinema;
import level3.models.CinemaSeat;
import level3.utils.KeyboardInput;

import java.util.Iterator;
import java.util.List;

public class CinemaManagement {
    private Cinema cinema;

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
    }

    public void showAllCinemaSeatsOnCinema() {
        String answer = "";
        if (this.cinema.getSeatManagement().getCinemaSeats().isEmpty()) {
            System.out.println("No hay butacas reservadas en la sala ");
        } else {
            System.out.println("Estas són las butacas reservadas en sala: ");
            for (int i = 0; i < this.cinema.getSeatManagement().getCinemaSeats().size(); i++) {
                answer += "\t" + this.cinema.getSeatManagement().getCinemaSeats().get(i) + "\n";
            }
            System.out.println(answer);
        }
    }

    public void checkCinemaSeatByPerson() {
        String answer;
        String person = KeyboardInput.readString("Introduce el nombre de la persona del cual mostrar reservas: ");
        if (this.cinema.getSeatManagement().getCinemaSeats().isEmpty()) {
            answer = ("No existe ningún asiento reservado por " + person + " en la sala");
        } else {
            answer = showCinemaSeatsByPerson(person);
        }
        System.out.println(answer);
    }

    private String showCinemaSeatsByPerson(String person) {
        String answer = "";
        int counter = 0;
        for (int i = 0; i < this.cinema.getSeatManagement().getCinemaSeats().size(); i++) {
            if (this.cinema.getSeatManagement().getCinemaSeats().get(i).getPerson().equalsIgnoreCase(person)) {
                answer += "\t" + this.cinema.getSeatManagement().getCinemaSeats().get(i) + "\n";
                counter++;
            }
        }
        if (counter == 0) {
            answer = person + " no tiene asientos reservados";
        }
        return answer;
    }


    public void reserveSeat() {
        int seatNumber = enterCinemaSeat();
        int row = enterRow();
        String person = KeyboardInput.readString("Introduce el nombre de la persona que va a hacer la reserva: ");
        this.cinema.getSeatManagement().addCinemaSeat(new CinemaSeat(row, seatNumber, person));
    }

    public void cancelReservationBySeat() {
        int seatNumber = enterCinemaSeat();
        int row = enterRow();
        int indexSeat = this.cinema.getSeatManagement().findCinemaSeat(row, seatNumber);
        if (indexSeat == -1) {
            System.out.println("El asiento nº " + seatNumber + " fila " + row + " esta vacío");
        } else {
            String person = this.cinema.getSeatManagement().getCinemaSeats().get(indexSeat).getPerson();
            this.cinema.getSeatManagement().removeCinemaSeat(row, seatNumber, person);
        }
    }

    public int findPerson(String person) {
        int indexPerson = -1;
        boolean found = false;
        int i = 0;
        while (i < this.cinema.getSeatManagement().getCinemaSeats().size() && !found) {
            if (this.cinema.getSeatManagement().getCinemaSeats().get(i).getPerson().equalsIgnoreCase(person)) {
                indexPerson = i;
                found = true;
            }
            i++;
        }
        return indexPerson;
    }

    public void cancelReservationByPerson() {
        int seatCounter = 0;
        String person = KeyboardInput.readString("Introduce el nombre de la persona a la que cancelar las reservas: ");
        int indexPerson = findPerson(person);
        if (indexPerson == -1) {
            System.out.println("No existe ningún asiento reservado por " + person + " en la sala");
        } else {
            List<CinemaSeat> seats = this.cinema.getSeatManagement().getCinemaSeats();
            Iterator<CinemaSeat> iterator = seats.iterator();
            while (iterator.hasNext()) {
                CinemaSeat seat = iterator.next();
                if (seat.getPerson().equalsIgnoreCase(person)) {
                    iterator.remove();
                    seatCounter++;
                }
            }
            System.out.println(person + " ha cancelado sus " + seatCounter + " asientos");
        }
    }

    private void checkEnterRow(int row) {
        if (row > this.cinema.getNumberOfRows() || row < 1) {
            throw new InvalidRowException("número de fila incorrecto, fila màx: " + cinema.getNumberOfRows());
        }
    }

    public int enterRow() {
        while (true) {
            try {
                int row = KeyboardInput.readInteger("Introduce el número de fila: ");
                checkEnterRow(row);
                return row;
            } catch (InvalidRowException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

    private void checkEnterCinemaSeat(int seatNumber) {
        if (seatNumber > this.cinema.getSeatsPerRow() || seatNumber < 1) {
            throw new IncorrectSeatException(
                    "número de asiento incorrecto, asiento màx: " + cinema.getSeatsPerRow()
            );
        }
    }

    public int enterCinemaSeat() {
        while (true) {
            try {
                int seatNumber = KeyboardInput.readInteger("Introduce el número de asiento: ");
                checkEnterCinemaSeat(seatNumber);
                return seatNumber;
            } catch (IncorrectSeatException e) {
                System.out.println("Error, " + e.getMessage());
            }
        }
    }

}
