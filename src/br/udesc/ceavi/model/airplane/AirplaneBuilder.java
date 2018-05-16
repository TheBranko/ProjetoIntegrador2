package br.udesc.ceavi.model.airplane;

import br.udesc.ceavi.model.routes.Route;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lucas.adriano, felipe lana, Kons
 */
public class AirplaneBuilder {

    protected Airplane airplane;
    protected BufferedReader reader;
    protected String[] lineInfo;

    public AirplaneBuilder() throws IOException {
        this.airplane = new Airplane();
        this.reader = new BufferedReader(new FileReader("airplanes.txt"));
    }

    public boolean readLine() throws IOException {
        String line;
        if ((line = reader.readLine()) != null) {
            lineInfo = line.split(";");
            return true;
        }

        return false;
    }

    void buildRoute(Route route) {
        airplane.setRoute(route);
    }

    void buildFuelCapacity() {
        airplane.setFuelCapacity(Double.parseDouble(lineInfo[0]));
    }

    void buildAverageFuel() {
        airplane.setAverageFuel(Double.parseDouble(lineInfo[1]));
    }

    void buildCurrentSpeed() {
        airplane.setCurrentSpeed(Double.parseDouble(lineInfo[2]));
    }

    void buildCurrentHight() {
        airplane.setCurrentHeight(Double.parseDouble(lineInfo[3]));
    }

    void buildCorrentLocation() {
        airplane.setCurrentLocation(airplane.getRoute().getEntryLocation());
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void startsNewAirplane() {
        airplane = new Airplane();
    }

}
