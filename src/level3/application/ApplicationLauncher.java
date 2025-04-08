package level3.application;

import level3.models.Cinema;
import level3.utils.KeyboardInput;

public class ApplicationLauncher {

    public static void start(Cinema cinema) {
        boolean exit = false;

        while (!exit) {
            switch (KeyboardInput.menuOption()) {
                case 1:
                    cinema.getCinemaManagement().showAllCinemaSeatsOnCinema();
                    break;
                case 2:
                    cinema.getCinemaManagement().checkCinemaSeatByPerson();
                    break;
                case 3:
                    cinema.getCinemaManagement().reserveSeat();
                    break;
                case 4:
                    cinema.getCinemaManagement().cancelReservationBySeat();
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
