package br.udesc.ceavi.model.routes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Avell
 */
public class LandingRouteBuilder extends RouteBuilder {
    
    public LandingRouteBuilder() throws FileNotFoundException, IOException {
        route = new LandingRoute();
        reader = new BufferedReader(new FileReader("LandingRoutes.txt"));
    }

    @Override
    protected void buildEntryLocation() {
        double longitude = Double.parseDouble(lineInfo[0]);
        double latitude = Double.parseDouble(lineInfo[1]);
        route.setEntryLocation(new Coordinate(longitude, latitude));
    }

    @Override
    protected void buildExitLocation() {
        double longitude = Double.parseDouble(lineInfo[2]);
        double latitude = Double.parseDouble(lineInfo[3]);
        route.setExitLocation(new Coordinate(longitude, latitude));
    }

    @Override
    protected void buildEntrySpeed() {
        route.setEntrySpeed(Double.parseDouble(lineInfo[4]));
    }

    @Override
    protected void buildExitSpeed() {
        route.setExitSpeed(Double.parseDouble(lineInfo[5]));
    }

    @Override
    public void startsNewRoute() {
        route = new LandingRoute();
    }

}
