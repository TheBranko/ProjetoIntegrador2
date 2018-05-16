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
        //necessita implementação
    }

    public Route getRoute() {
        return route;
    }
    
}
