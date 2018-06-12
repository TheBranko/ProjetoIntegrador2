
package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.controlller.Utils;
import br.udesc.ceavi.model.airplane.Airplane;

/**
 *
 * @author Avell
 */
public class CalculateSpeedVisitor extends VisitorAirplane {
    
    @Override
    public void visit(Airplane airplane) {
        value = airplane.getCurrentSpeed() + airplane.getAcceleration() * Utils.getInstance().getUpdateInterval() ;
    }
}
