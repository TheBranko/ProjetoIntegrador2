package br.udesc.ceavi.model.routes;

/**
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
abstract public class Route {
 
    private Coordinate entryLocation;
    private Coordinate exitLocation;
    
    private double entrySpeed;
    private double exitSpeed;
    
    private double length;

    public Coordinate getEntryLocation() {
        return entryLocation;
    }

    public void setEntryLocation(Coordinate entryRoute) {
        this.entryLocation = entryRoute;
    }

    public Coordinate getExitLocation() {
        return exitLocation;
    }

    public void setExitLocation(Coordinate exitRoute) {
        this.exitLocation = exitRoute;
    }

    public double getEntrySpeed() {
        return entrySpeed;
    }

    public void setEntrySpeed(double entrySpeed) {
        this.entrySpeed = entrySpeed;
    }

    public double getExitSpeed() {
        return exitSpeed;
    }

    public void setExitSpeed(double exitSpeed) {
        this.exitSpeed = exitSpeed;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}