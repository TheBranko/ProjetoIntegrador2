package br.udesc.ceavi.model.airplane;

import br.udesc.ceavi.model.routes.Route;
import br.udesc.ceavi.model.routes.Coordinate;

/**
 * @author lucas.adriano, felipe lana, Kons
 */
public class Airplane implements Comparable<Airplane> {

    private Route route;

    private double score;

    private double totalFuel; //alterar o que estava como fuelCapacity para totalFuel
    private double averageFuel;
    private double currentSpeed;
    private double currentHeight;

    private Coordinate currentLocation;

    public double getFuelCapacity() {
        return totalFuel;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.totalFuel = fuelCapacity;
    }

    public double getAverageFuel() {
        return averageFuel;
    }

    public void setAverageFuel(double averageFuel) {
        this.averageFuel = averageFuel;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getScore() {
        return score;
    }

    public void calculateScore(double distanceToAirport) {
        double quantoPodeVoar = totalFuel / averageFuel;
        score = quantoPodeVoar - distanceToAirport;
    }
    
    public double getCurrentHeight() {
        return currentHeight;
    }

    public void setCurrentHeight(double currentHeight) {
        this.currentHeight = currentHeight;
    }

    public Coordinate getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Coordinate currentLocation) {
        this.currentLocation = currentLocation;
    }

    
    @Override
    public int compareTo(Airplane o) {
        if (this.getScore() == o.getScore()) {
            return 0;
        }
        return this.getScore() > o.getScore() ? -1 : 1;
    }
    
    public void move() {
        double kmTravelled = currentSpeed * 3;
    }
}
