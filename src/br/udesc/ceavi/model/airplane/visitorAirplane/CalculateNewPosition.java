package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.Main;
import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.routes.Coordinate;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class CalculateNewPosition extends VisitorAirplane {

    @Override
    public void visit(Airplane airplane, double time) throws Exception {
        double necessaryFuel = airplane.consumeFuel(time);

        if (necessaryFuel <= airplane.getTotalFuel()) {
            airplane.setTotalFuel(airplane.getTotalFuel() - necessaryFuel);

            double metersTravelled = (airplane.getCurrentSpeed() * time) + 
                                     ((airplane.getAcceleration() * Math.pow(time, 2)) / 2);
            
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
            
            if (airplane.getId() != 0) {
                int cord1 = (int) x1 / 50;
                int cord2 = (int) y1 / 50;
                int cord3 = (int) newX / 50;
                int cord4 = (int) newY / 50;

                Graphics g = Main.panel.getGraphics();
                g.setColor(getColor(airplane));

                if (x2 >= 0 && y2 >= 0) {
                    g.drawLine(cord1 + 200, cord2 + 200, cord3 + 200, cord4 + 200);
                }
                else if (x2 > 0 && y2 <= 0) {
                    g.drawLine(cord1, cord2, cord3, cord4);
                }
                else if (x2 <= 0 && y2 <= 0) {
                    g.drawLine(cord1, cord2 + 200, cord3, cord4 + 200);
                }
                else {
                    g.drawLine(cord1 + 200, cord2, cord3 + 200, cord4);
                }
            }
        }
        else {
            throw new Exception("Out of fuel");
        }
    }
    
    private Color getColor(Airplane airplane){
        switch(airplane.getId()){
            case 1: return Color.BLUE;
            case 2: return Color.RED;
            case 3: return Color.GREEN;
            case 4: return Color.ORANGE;
            case 5: return Color.LIGHT_GRAY;
        }
        return Color.BLACK;
    }
}