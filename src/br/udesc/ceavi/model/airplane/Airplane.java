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
    private double averageFuelConsumption;
    private double currentSpeed;
    private double currentHeight;

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
    
    public void move() {
        double metersTravelled = currentSpeed * 3;
        
        double x1 = currentLocation.getLongitude();
        double y1 = currentLocation.getLatitude();
        
        double x2 = route.getExitLocation().getLongitude();
        double y2 = route.getExitLocation().getLatitude();
                
        //Calculo do Rumo
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        double rumo = Math.abs(Math.toDegrees(Math.atan(deltaX / deltaY)));
        
        //Calculo do azimute
        double azimute = 0;
        if(deltaX >= 0 && deltaY >= 0) {
            azimute = rumo;
        } else if(deltaX >= 0 && deltaY < 0) {
            azimute = 180 - rumo;
        } else if(deltaX < 0 && deltaY < 0) {
            azimute = rumo + 180;
        } else if(deltaX < 0 && deltaY >= 0) {
            azimute = 360 - rumo;
        }
        
        //Projeção cartográfica 
        double projecaoX = metersTravelled * Math.sin(Math.toRadians(azimute));
        double projecaoY = metersTravelled * Math.cos(Math.toRadians(azimute));
        
        double newX = currentLocation.getLongitude() + projecaoX; 
        double newY = currentLocation.getLatitude() + projecaoY;
        
        currentLocation.setLongitude(newX);
        currentLocation.setLatitude(newY);
    } 
}
