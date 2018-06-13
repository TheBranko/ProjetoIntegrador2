package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateAccelararionVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateNewPosition;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateSpeedVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateTimeOfArrivalVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.VisitorAirplane;
import br.udesc.ceavi.model.routes.Coordinate;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * @author lucas.adriano, Kevin Kons
 */
public class TowerControl {

    private ControllerData data;
    private PriorityQueue<Airplane> airplanes = new PriorityQueue<>();

    public TowerControl() throws IOException, Exception {
        data = new ControllerData();
//        airplanes = new PriorityQueue() {};
//        airplanes = new PriorityQueue<Airplane>();

        Airplane a = data.buildAirplane();
        Airplane a2 = data.buildAirplane();
        airplanes.add(a);
        airplanes.add(a2);

        System.out.println(a.getTimeToRouteEnd() + " Tempo a1");
        System.out.println(a.getCurrentLocation());

        VisitorAirplane ap = new CalculateAccelararionVisitor();
        a.accept(ap, a2.getTimeToRouteEnd() + 5);
        a.setAcceleration((double) ap.getValue());

        double timeToRouteEnd = a.getTimeToRouteEnd();
        do {
            VisitorAirplane ap2 = new CalculateTimeOfArrivalVisitor();
            a.accept(ap2);
            timeToRouteEnd = (double) ap2.getValue();
            a.setTimeToRouteEnd(timeToRouteEnd);

            VisitorAirplane ap3 = new CalculateNewPosition();
            a.accept(ap3, Utils.getInstance().getUpdateInterval());
            a.setCurrentLocation((Coordinate) ap3.getValue());

            VisitorAirplane ap4 = new CalculateSpeedVisitor();
            a.accept(ap4);
            a.setCurrentSpeed((double) ap4.getValue());

            System.out.println("-----\n"
                    + a.getAcceleration() + " Aceleração \n"
                    + a.getTimeToRouteEnd() + " Tempo até o final da rota\n"
                    + a.getCurrentLocation() + " Posição atual\n"
                    + a.getCurrentSpeed() + " Velocidade atual");

        } while (timeToRouteEnd > 1);

    }
    
    public void run() {
        
    }

}
