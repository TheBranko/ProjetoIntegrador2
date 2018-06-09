package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.routes.Coordinate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lucas.adriano
 */
public class TowerControl {

    private ControllerData data;
    private List<Airplane> airplanes = new ArrayList();

    public TowerControl() throws IOException, Exception {
        data = new ControllerData();
        Airplane a = data.buildAirplane();
        airplanes.add(a);
        airplanes.add(data.buildAirplane());
        airplanes.add(data.buildAirplane());
        
//        for(Airplane e : airplanes) {
//            System.out.println(e.getTotalFuel());
//        }
        
        double distance = Utils.getInstance().calculateDistance(a.getCurrentLocation(), data.getLandingRoute().getEntryLocation());
        a.move();
        a.calculateScore(distance);
        
    }
}   
