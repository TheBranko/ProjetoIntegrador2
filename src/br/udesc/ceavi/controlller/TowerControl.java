package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateAccelararionVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateNewPosition;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateSpeedVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateTimeOfArrivalVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.VisitorAirplane;
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
        
        System.out.println(a.getTimeToRouteEnd() + " Tempo anterior até o final da rota");
        
        VisitorAirplane ap = new CalculateAccelararionVisitor();
        a.accept(ap, 42);
        a.setAcceleration((double) ap.getValue());
        
        VisitorAirplane ap2 = new CalculateTimeOfArrivalVisitor();
        a.accept(ap2);
        a.setTimeToRouteEnd((double) ap2.getValue());
        
        VisitorAirplane ap3 = new CalculateNewPosition();
        a.accept(ap3, 3);
        a.setCurrentLocation((Coordinate) ap3.getValue());
        
        VisitorAirplane ap4 = new CalculateSpeedVisitor();
        a.accept(ap4);
        a.setCurrentSpeed((double) ap4.getValue());
        System.out.println(a.getCurrentSpeed() + "Velocidade atual");
        
        System.out.println(a.getTimeToRouteEnd() + " Novo tempo até o final da rota");
        System.out.println(a.getAcceleration());
        
    }
}   
