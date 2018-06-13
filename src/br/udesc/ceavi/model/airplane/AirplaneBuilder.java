package br.udesc.ceavi.model.airplane;

import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateScoreVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.CalculateTimeToRouteEndVisitor;
import br.udesc.ceavi.model.airplane.visitorAirplane.VisitorAirplane;
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
    private int count = 0;

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

    void buildTotalFuel() {
        airplane.setTotalFuel(Double.parseDouble(lineInfo[0].replaceAll("\\D+", "")));
    }

    void buildAverageFuelConsumption() {
        airplane.setAverageFuelConsumption(Double.parseDouble(lineInfo[1]));
    }

    void buildCurrentSpeed() {
        airplane.setCurrentSpeed(airplane.getRoute().getEntrySpeed());
    }

    void buildCurrentHight() {
        airplane.setCurrentHeight(Double.parseDouble(lineInfo[2]));
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

    public void buildAcceleration() {
        airplane.setAcceleration(Double.parseDouble(lineInfo[3]));
    }

    public void buildInclination() {
        airplane.setInclination(Double.parseDouble(lineInfo[4]));
    }

    public void buildTimeToRouteEnd() {
        VisitorAirplane v = new CalculateTimeToRouteEndVisitor();
        airplane.accept(v);
        airplane.setTimeToRouteEnd((double) v.getValue());
    }

    public void buildScore() {
        VisitorAirplane v = new CalculateScoreVisitor();
        airplane.accept(v);
        airplane.setScore((double) v.getValue());
    }

    public void buildId() {
        airplane.setId(Integer.parseInt(lineInfo[5]));
    }

}
