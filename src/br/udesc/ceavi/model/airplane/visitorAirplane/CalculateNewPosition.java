package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.routes.Coordinate;

/**
 *
 * @author Avell
 */
public class CalculateNewPosition extends VisitorAirplane {

    @Override
    public void visit(Airplane airplane, double time) throws Exception {
        double necessaryFuel = airplane.consumeFuel(time);

        if (necessaryFuel <= airplane.getTotalFuel()) {
            airplane.setTotalFuel(airplane.getTotalFuel() - necessaryFuel);

            double metersTravelled = airplane.getCurrentSpeed() + (airplane.getAcceleration() * Math.pow(time, 2)) / 2;
            System.out.println(metersTravelled + "m travelled at " + airplane.getCurrentSpeed() + "m/s ");
            
            double x1 = airplane.getCurrentLocation().getLongitude();
            double y1 = airplane.getCurrentLocation().getLatitude();

            double x2 = airplane.getRoute().getExitLocation().getLongitude();
            double y2 = airplane.getRoute().getExitLocation().getLatitude();

            double deltaX = x2 - x1;
            double deltaY = y2 - y1;
            double rumo = Math.abs(Math.toDegrees(Math.atan(deltaX / deltaY)));

            double azimute = 0;
            if (deltaX >= 0 && deltaY >= 0) {
                azimute = rumo;
            } else if (deltaX >= 0 && deltaY < 0) {
                azimute = 180 - rumo;
            } else if (deltaX < 0 && deltaY < 0) {
                azimute = rumo + 180;
            } else if (deltaX < 0 && deltaY >= 0) {
                azimute = 360 - rumo;
            }

            double projecaoX = metersTravelled * Math.sin(Math.toRadians(azimute));
            double projecaoY = metersTravelled * Math.cos(Math.toRadians(azimute));

            double newX = airplane.getCurrentLocation().getLongitude() + projecaoX;
            double newY = airplane.getCurrentLocation().getLatitude() + projecaoY;

            value = new Coordinate(newX, newY);
        } else {
            throw new Exception("Out of fuel");
        }
    }
}
