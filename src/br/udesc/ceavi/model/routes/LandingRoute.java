package br.udesc.ceavi.model.routes;

import br.udesc.ceavi.model.airplane.Airplane;

/**
 * @author lucas.adriano, felipe lana, Kons
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
    private Airplane landingAirplane;

    public LandingRoute() {
        super();
    }

    public Airplane getLandingAirplane() {
        return landingAirplane;
    }

    public void setLandingAirplane(Airplane landingAirplane) {
        this.landingAirplane = landingAirplane;
    }

    public double getGroundLength() {
        return groundLength;
    }

    public void setGroundLength(double groundLength) {
        this.groundLength = groundLength;
    }
    
    /**
     * Time to land = Time to reach the ground + time to stop the plane and unload the passengers
     * @return 
     */
    public double getTimeToLand() {
        return 104 + TOTAL_TIME_PARKING;
    };
}