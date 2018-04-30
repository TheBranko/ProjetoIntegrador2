package br.udesc.ceavi.model;

import br.udesc.ceavi.model.entity.Plane;

/**
 * @author lucas.adriano
 */
public class PlaneDirector {
    
    private PlaneBuilder builder;

    public PlaneDirector(PlaneBuilder builder) {
        this.builder = builder;
    }
    
    public void build() {
        builder.buildFuelCapacity();
        builder.buildAverageFuel();
        builder.buildLandingSpeed();
        builder.buildCurrentSpeed();
    }
    
    public Plane getPlane() {
        return builder.getPlane();
    }
}