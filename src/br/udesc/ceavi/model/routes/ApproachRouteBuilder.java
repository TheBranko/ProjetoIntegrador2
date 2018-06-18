package br.udesc.ceavi.model.routes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class ApproachRouteBuilder extends RouteBuilder {

    public ApproachRouteBuilder() throws IOException {
        route = new ApproachRoute();
        reader = new BufferedReader(new FileReader("ApproachRoutes.txt"));
    }

    @Override
    protected void buildEntryLocation() {
        double longitude = Double.parseDouble(lineInfo[0].replaceAll("\\D+",""));
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
    public void startNewRoute() {
        route = new ApproachRoute();
    }

}
