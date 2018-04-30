package br.udesc.ceavi.model;

import br.udesc.ceavi.model.entity.Plane;

/**
 * @author lucas.adriano
 */
abstract public class PlaneBuilder {
    
    protected Plane plane;

    public PlaneBuilder() {
        this.plane = new Plane();
    }
    
    public void buildFuelCapacity() {}
    
    public void buildAverageFuel() {}
    
    public void buildLandingSpeed() {}
    
    public void buildCurrentSpeed() {}

    public Plane getPlane() {
        return plane;
    }
}