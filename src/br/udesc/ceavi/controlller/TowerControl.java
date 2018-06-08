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

        for(int i = 0; i < 10; i++) {
            System.out.println(data.buildAirplane().getInclination());
        }
        
        double distance = calculateDistance(a.getCurrentLocation(), data.getLandingRoute().getEntryLocation());
        a.move();
        a.calculateScore(distance);
        
    }
    
    public double calculateDistance(Coordinate a, Coordinate b) {
        double deltaY = b.getLatitude() - a.getLatitude();
        double deltaX = b.getLongitude() - a.getLongitude();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}   
