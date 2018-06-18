package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.utils.Utils;
import br.udesc.ceavi.model.airplane.Airplane;

/**
 *
 * @author Avell
 */
public class CalculateTimeToRouteEndVisitor extends VisitorAirplane {

    @Override
    public void visit(Airplane airplane) {
        double distanceToRouteEnd = Utils.getInstance().calculateDistance(airplane.getCurrentLocation(), airplane.getRoute().getExitLocation());
        
        if (airplane.getAcceleration() == 0) {
            value = distanceToRouteEnd / airplane.getCurrentSpeed();
        } else {
            double delta = Math.pow(airplane.getCurrentSpeed(), 2.0) + (2.0 * airplane.getAcceleration() * distanceToRouteEnd);
            value = (-airplane.getCurrentSpeed() + Math.sqrt(delta)) / airplane.getAcceleration();
        }
    }
}