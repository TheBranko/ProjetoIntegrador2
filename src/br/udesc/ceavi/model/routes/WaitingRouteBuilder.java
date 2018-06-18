package br.udesc.ceavi.model.routes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class WaitingRouteBuilder extends RouteBuilder{
    
    public WaitingRouteBuilder() throws FileNotFoundException {
        route = new WaitingRoute();
        reader = new BufferedReader(new FileReader("WaitingRoutes.txt"));
    }

    @Override
    protected void buildEntryLocation() {
        double latitude = Double.parseDouble(lineInfo[0]);
        double longitude = Double.parseDouble(lineInfo[1]);
        route.setEntryLocation(new Coordinate(longitude, latitude));
    }

    @Override
    protected void buildExitLocation() {
        double latitude = Double.parseDouble(lineInfo[2]);
        double longitude = Double.parseDouble(lineInfo[3]);
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
    public void startNewRoute() {
        route = new WaitingRoute();
    }

}
