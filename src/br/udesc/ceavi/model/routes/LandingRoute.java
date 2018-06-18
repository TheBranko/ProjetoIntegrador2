package br.udesc.ceavi.model.routes;

import br.udesc.ceavi.model.airplane.Airplane;

/**
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class LandingRoute extends Route {
    
    /**
     * Time to stop the plane and unload the passengers
     */
    public static final double TOTAL_TIME_PARKING = 20;
    
    /**
     * Length of the route on the ground
     */
    private double groundLength;
    private Airplane lastAirplaneInto;

    public LandingRoute() {
        super();
    }

    public Airplane getLastAirplaneInto() {
        return lastAirplaneInto;
    }

    public void setLastAirplaneInto(Airplane lastAirplaneInto) {
        this.lastAirplaneInto = lastAirplaneInto;
    }

    public double getGroundLength() {
        return groundLength;
    }

    public void setGroundLength(double groundLength) {
        this.groundLength = groundLength;
    }
}