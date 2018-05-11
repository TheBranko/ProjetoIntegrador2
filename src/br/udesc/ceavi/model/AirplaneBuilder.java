package br.udesc.ceavi.model;

import br.udesc.ceavi.model.entity.Airplane;

/**
 * @author lucas.adriano, felipe lana
 */
abstract public class AirplaneBuilder {
    
    protected Airplane airplane;

    public AirplaneBuilder() {
        this.airplane = new Airplane();
    }
    
    public void buildFuelCapacity() {}
    
    public void buildAverageFuel() {}
    
    public void buildLandingSpeed() {}
    
    public void buildCurrentSpeed() {}

    public Airplane getAirplane() {
        return airplane;
    }
}