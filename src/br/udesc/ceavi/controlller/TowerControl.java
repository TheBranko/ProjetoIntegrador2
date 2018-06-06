package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.routes.Coordinate;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * @author lucas.adriano
 */
public class TowerControl {

    private ControllerData data;
    private PriorityQueue<Airplane> airplanes = new PriorityQueue();

    public TowerControl() throws IOException, Exception {
        data = new ControllerData();
        Airplane a = data.buildAirplane();
        double distance = calculateDistance(a.getCurrentLocation(), data.getLandingRoute().getEntryLocation());
        a.move();
        a.calculateScore(distance);
        
    }
    
    public double calculateDistance(Coordinate a, Coordinate b) {
        double x = Math.abs(a.getLatitude() - b.getLatitude());
        double y = Math.abs(a.getLongitude() - b.getLongitude());
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}   
