package level3;

import level3.application.ApplicationLauncher;
import level3.models.Cinema;

public class MainCinema {

    public static void main(String[] args) {

        Cinema cinema = new Cinema();

        ApplicationLauncher.start(cinema);

    }

}
