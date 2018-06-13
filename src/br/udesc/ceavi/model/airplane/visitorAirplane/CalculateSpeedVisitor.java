package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.utils.Utils;
import br.udesc.ceavi.model.airplane.Airplane;

/**
 *
 * @author Avell
 */
public class CalculateSpeedVisitor extends VisitorAirplane {

    @Override
    public void visit(Airplane airplane) {
        if (airplane.getCurrentSpeed() > 66) {
            value = airplane.getCurrentSpeed() + airplane.getAcceleration() * Utils.getInstance().getUpdateInterval();
        } else {
            value = 66.0;
            airplane.setAcceleration(0);
        }
    }
}
