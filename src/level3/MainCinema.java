package level3;

import level3.controller.RunMain;
import level3.models.Cinema;

public class MainCinema {

    public static void main(String[] args) {

        Cinema cinema = new Cinema();

        RunMain.start(cinema);

    }

}
