package level3.services;

import level3.exceptions.IncorrectPersonNameException;
import level3.exceptions.IncorrectSeatException;
import level3.exceptions.InvalidRowException;
import level3.models.Cinema;
import level3.models.CinemaSeat;
import level3.utils.KeyboardInput;

public class CinemaManagement {
    private Cinema cinema;

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
    }

    public void showCinemaSeats() {
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

    public void showCinemaSeatByPerson() {
        int seatCounter = 0;
        String answer = "";
        String person = enterPerson("Introduce el nombre de la persona del cual mostrar reservas: ");
        if (this.cinema.getSeatManagement().getCinemaSeats().isEmpty()) {
            System.out.println("No existe ningún asiento reservado por " + person + " en la sala");
        } else {
            for (int i = 0; i < this.cinema.getSeatManagement().getCinemaSeats().size(); i++) {
                if (this.cinema.getSeatManagement().getCinemaSeats().get(i).getPerson().equalsIgnoreCase(person)) {
                    answer += "\t" + this.cinema.getSeatManagement().getCinemaSeats().get(i) + "\n";
                    seatCounter++;
                }
            }
            if (seatCounter > 0) {
                System.out.println("Asientos reservados por " + person + ":\n" + answer);
            } else {
                System.out.println("No existe ningún asiento reservado por " + person + " en la sala");
            }
        }
    }

    public void reserveCinemaSeat() {
        int seatNumber = enterCinemaSeat();
        int row = enterRow();
        String person = enterPerson("Introduce el nombre de la persona que va a hacer la reserva: ");
        this.cinema.getSeatManagement().addCinemaSeat(new CinemaSeat(row, seatNumber, person));
    }

    public void cancelReservation() {
        String person = enterPerson("Introduce el nombre de la persona a la que cancelar la reserva: ");
        int seatNumber = enterCinemaSeat();
        int row = enterRow();
        cinema.getSeatManagement().removeCinemaSeat(row, seatNumber, person);
    }

    public void cancelReservationByPerson() {
        int seatCounter = 0;
        String person = enterPerson("Introduce el nombre de la persona a la que cancelar las reservas: ");
        for (int i = 0; i < this.cinema.getSeatManagement().getCinemaSeats().size(); i++) {
            if (this.cinema.getSeatManagement().getCinemaSeats().get(i).getPerson().equalsIgnoreCase(person)) {
                cinema.getSeatManagement().getCinemaSeats().remove(i);
                i--; // Offsets deleted position
                seatCounter++;
            }
        }
        if (seatCounter > 0) {
            System.out.println(person + " ha cancelado sus " + seatCounter + " asientos");
        } else {
            System.out.println("No existe ningún asiento reservado por " + person + " en la sala");
        }
    }

    public String enterPerson(String message){
        boolean correct = false;
        String person;
        do {
            person = KeyboardInput.readString(message);
            try {
                if (person.matches("\\d+")) {
                    throw new IncorrectPersonNameException("el nombre de la persona no puede contener números");
                }
                correct = true;
            } catch (IncorrectPersonNameException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return person;
    }

    public int enterRow() {
        int row = 0;
        boolean correct = false;
        do {
            try {
                row = KeyboardInput.readInteger("Introduce el número de fila: ");
                if (row > this.cinema.getNumberOfRows() || row < 1) {
                    throw new InvalidRowException("número de fila incorrecto, fila màx: " + cinema.getNumberOfRows());
                }
                correct = true;
            } catch (InvalidRowException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return row;
    }

    public int enterCinemaSeat() {
        int seatNumber = 0;
        boolean correct = false;
        do {
            try {
                seatNumber = KeyboardInput.readInteger("Introduce el número de asiento: ");
                if (seatNumber > this.cinema.getSeatsPerRow() || seatNumber < 1) {
                    throw new IncorrectSeatException(
                            "número de asiento incorrecto, asiento màx: " + cinema.getSeatsPerRow()
                    );
                }
                correct = true;
            } catch (IncorrectSeatException e) {
                System.out.println("Error, " + e.getMessage());
            }
        } while (!correct);
        return seatNumber;
    }

}
