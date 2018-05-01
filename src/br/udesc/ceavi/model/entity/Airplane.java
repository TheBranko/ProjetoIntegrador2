package br.udesc.ceavi.model.entity;

/**
 * @author lucas.adriano, felipe lana
 */
public class Airplane {
    
    private Route route;
 
    private double fuelCapacity;
    private double averageFuel;
    private double landingSpeed;
    private double currentSpeed;
    private int score;

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public double getAverageFuel() {
        return averageFuel;
    }

    public void setAverageFuel(double averageFuel) {
        this.averageFuel = averageFuel;
    }

    public double getLandingSpeed() {
        return landingSpeed;
    }

    public void setLandingSpeed(double landingSpeed) {
        this.landingSpeed = landingSpeed;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}