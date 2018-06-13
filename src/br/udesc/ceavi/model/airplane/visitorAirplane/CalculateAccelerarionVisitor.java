package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.utils.Utils;
import br.udesc.ceavi.model.airplane.Airplane;

/**
 *
 * @author Avell
 */
public class CalculateAccelerarionVisitor extends VisitorAirplane {

    @Override
    public void visit(Airplane airplane, double time) {
        double speed = airplane.getCurrentSpeed();
        if (speed > 66) {
            double distanceToRouteEnd = Utils.getInstance().calculateDistance(
                    airplane.getCurrentLocation(), airplane.getRoute().getExitLocation());

            double acceleration = ((distanceToRouteEnd - (speed * time)) * 2)
                    / Math.pow(time, 2);
            value = acceleration;
        } else {
            value = 0;
        }
    }

}
