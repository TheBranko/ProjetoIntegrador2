package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.utils.Utils;

/**
 *
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class CalculateScoreVisitor extends VisitorAirplane {
    
    @Override
    public void visit(Airplane airplane) {
        double quantoPodeVoar = airplane.getTotalFuel() / airplane.getAverageFuelConsumption();
        value = quantoPodeVoar - Utils.getInstance().calculateDistance(airplane.getCurrentLocation(), airplane.getRoute().getExitLocation());
    }
}
