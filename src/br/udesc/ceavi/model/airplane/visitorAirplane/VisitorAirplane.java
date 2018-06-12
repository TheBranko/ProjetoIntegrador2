
package br.udesc.ceavi.model.airplane.visitorAirplane;

import br.udesc.ceavi.model.airplane.Airplane;

/**
 *
 * @author Avell
 */
public abstract class VisitorAirplane {
    
    protected Object value;
    
    public void visit(Airplane airplane) {}
    public void visit(Airplane airplane, double time) throws Exception {}
    
    public Object getValue() {
        return value;
    }
}
