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
//        double x1 = Math.toRadians(currentLocation.getLongitude());
//        double x2 = Math.toRadians(route.getExitLocation().getLongitude());
//        double y1 = Math.toRadians(currentLocation.getLatitude());
//        double y2 = Math.toRadians(route.getExitLocation().getLatitude());
        
        double x1 = currentLocation.getLongitude();
        double x2 = route.getExitLocation().getLongitude();
        double y1 = currentLocation.getLatitude();
        double y2 = route.getExitLocation().getLatitude();
        
        System.out.println("(" + x1 + "," + y1 + ") (" + x2 + "," + y2 + ")");
                

        //Calculo do Rumo (r)
        double deltaX = x2 - x1;
        double deltaY = y2 - y1;
        
        double rumo = Math.abs(Math.atan(deltaX / deltaY));
//        double rumo = Math.abs(Math.atan(Math.toRadians(3) / Math.toRadians(-6)));
        System.out.println("rumo = " + rumo);
        
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
        double projecaoX = kmTravelled * Math.sin(azimute);
        double projecaoY = kmTravelled * Math.cos(azimute);
        
        double newX = Math.toRadians(currentLocation.getLongitude()) + projecaoX; 
        double newY = Math.toRadians(currentLocation.getLatitude()) + projecaoY;
        
        System.out.println(currentSpeed);
        System.out.println(kmTravelled);
        System.out.println(newX + " " + newY);
        currentLocation.setLongitude(newX);
        currentLocation.setLatitude(newY);
    } 
}
