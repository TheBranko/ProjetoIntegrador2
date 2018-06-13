package br.udesc.ceavi.model.airplane;

import br.udesc.ceavi.model.airplane.visitorAirplane.VisitorAirplane;
import br.udesc.ceavi.model.routes.Route;
import br.udesc.ceavi.model.routes.Coordinate;

/**
 * @author lucas.adriano, felipe lana, Kons
 */
public class Airplane implements Comparable<Airplane> {

    private Route route;

    private double score;

    private double totalFuel;
    private double averageFuelConsumption;
    private double currentSpeed;
    private double currentHeight;
    private double acceleration;
    private double inclination;
    private double timeToRouteEnd;

    private Coordinate currentLocation;

    public double getTotalFuel() {
        return totalFuel;
    }

    public void setTotalFuel(double totalFuel) {
        this.totalFuel = totalFuel;
    }

    public double getAverageFuel() {
        return averageFuelConsumption;
    }

    public void setAverageFuelConsumption(double averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
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

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getInclination() {
        return inclination;
    }

    public void setInclination(double inclination) {
        this.inclination = inclination;
    }

    public void calculateScore(double distanceToAirport) {
        double quantoPodeVoar = totalFuel / averageFuelConsumption;
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

    public double consumeFuel(double time) {
        double consumedFuel = 0;
        if ((currentHeight >= 9200 && currentHeight <= 12200 && currentSpeed >= 225) && inclination == 90) {
            consumedFuel = averageFuelConsumption * time;
        } else if (inclination > 90) {
            consumedFuel = (averageFuelConsumption * time) / 3;
        } else if (inclination < 90) {
            consumedFuel = (averageFuelConsumption * time) * 2;
        } else if (currentSpeed <= 16.6667) {
            consumedFuel = (averageFuelConsumption * time) / 4;
        }
        return consumedFuel;
    }
    
    public void accept(VisitorAirplane visitor) {
        visitor.visit(this);
    }
    
    public void accept(VisitorAirplane visitor, double time) throws Exception {
        visitor.visit(this, time);
    }

    public double getTimeToRouteEnd() {
        return timeToRouteEnd;
    }

    public void setTimeToRouteEnd(double timeToRouteEnd) {
        this.timeToRouteEnd = timeToRouteEnd;
    }
    
    
    
}
