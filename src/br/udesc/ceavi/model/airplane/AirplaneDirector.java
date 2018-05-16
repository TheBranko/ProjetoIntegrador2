package br.udesc.ceavi.model.airplane;

import br.udesc.ceavi.model.routes.Route;
import java.io.IOException;

/**
 * @author lucas.adriano, felipe lana
 */
public class AirplaneDirector {

    private AirplaneBuilder builder;

    public AirplaneDirector(AirplaneBuilder builder) {
        this.builder = builder;
    }

    public void build(Route route) throws IOException{
        builder.readLine();
        builder.buildRoute(route);
        builder.buildFuelCapacity();
        builder.buildAverageFuel();
        builder.buildCurrentSpeed();
        builder.buildCurrentHight();
        builder.buildCorrentLocation();
    }

    public Airplane getAirplane() {
        return builder.getAirplane();
    }
}
