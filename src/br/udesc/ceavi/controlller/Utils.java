package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.routes.Coordinate;

/**
 *
 * @author Avell
 */
public class Utils {

    private Utils() {
    }

    private static Utils utils = null;

    public static Utils getInstance() {
        if (utils == null) {
            utils = new Utils();
        }

        return utils;
    }

    public double calculateDistance(Coordinate a, Coordinate b) {
        double deltaY = b.getLatitude() - a.getLatitude();
        double deltaX = b.getLongitude() - a.getLongitude();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

}
