package level3.controller;

import level3.models.Cinema;
import level3.utils.KeyboardInput;

public class RunMain {
    public static void start(Cinema cinema) {
        boolean exit = false;

        while (!exit) {
            switch (KeyboardInput.menuOption()) {
                case 1:
                    cinema.getCinemaManagement().showCinemaSeats();
                    break;
                case 2:
                    cinema.getCinemaManagement().showCinemaSeatByPerson();
                    break;
                case 3:
                    cinema.getCinemaManagement().reserveCinemaSeat();
                    break;
                case 4:
                    cinema.getCinemaManagement().cancelReservation();
                    break;
                case 5:
                    cinema.getCinemaManagement().cancelReservationByPerson();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    exit = true;
                    break;
            }
        }
    }
}
