package br.udesc.ceavi.model;

import br.udesc.ceavi.model.entity.Airplane;

/**
 * @author lucas.adriano, felipe lana
 */
public class AirplaneDirector {
    
    private AirplaneBuilder builder;

    public AirplaneDirector(AirplaneBuilder builder) {
        this.builder = builder;
    }
    
    public void build() {
        builder.buildFuelCapacity();
        builder.buildAverageFuel();
        builder.buildLandingSpeed();
        builder.buildCurrentSpeed();
    }
    
    public Airplane getAirplane() {
        return builder.getAirplane();
    }
}