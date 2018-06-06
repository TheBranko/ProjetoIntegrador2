package br.udesc.ceavi.model.routes;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Avell
 */
public abstract class RouteBuilder {
    
    protected Route route;
    protected BufferedReader reader;
    protected String[] lineInfo;

    public boolean readLine() throws IOException {
        String line;
        if((line = reader.readLine()) != null) {
            lineInfo = line.split(";");
            System.out.println(lineInfo.length);
            return true;
        } 
        return false;
    }

    protected abstract void buildEntryLocation();

    protected abstract void buildExitLocation();

    protected abstract void buildEntrySpeed();

    protected abstract void buildExitSpeed();
    
    public abstract void startsNewRoute();

    void buildLength() {
        double deltaX = route.getExitLocation().getLongitude() - route.getEntryLocation().getLongitude();
        double deltaY = route.getExitLocation().getLatitude() - route.getEntryLocation().getLatitude();
        route.setLength(Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    public Route getRoute() {
        return route;
    }
    
}
