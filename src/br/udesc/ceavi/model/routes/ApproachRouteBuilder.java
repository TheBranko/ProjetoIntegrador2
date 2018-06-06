package br.udesc.ceavi.model.routes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Avell
 */
public class ApproachRouteBuilder extends RouteBuilder {

    public ApproachRouteBuilder() throws IOException {
        route = new ApproachRoute();
        reader = new BufferedReader(new FileReader("ApproachRoutes.txt"));
    }

    @Override
    protected void buildEntryLocation() {
//        System.out.println(lineInfo[0]);
//        System.out.println(lineInfo[1]);
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
    public void startsNewRoute() {
        route = new ApproachRoute();
    }

}
