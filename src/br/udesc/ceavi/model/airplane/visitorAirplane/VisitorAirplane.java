
package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.model.airplane.Airplane;

/**
 *
 * @author Avell
 */
public interface VisitorAirplane {
    
    public void visit(Airplane airplane);
}
