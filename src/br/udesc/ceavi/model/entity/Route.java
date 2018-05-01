package br.udesc.ceavi.model.entity;

/**
 * @author lucas.adriano, felipe lana
 */
abstract public class Route {
 
    private Coordinate entryRoute;
    private Coordinate exitRoute;
    
    private double entrySpeed;
    private double exitSpeed;
    
    private double length;

    public Coordinate getEntryRoute() {
        return entryRoute;
    }

    public void setEntryRoute(Coordinate entryRoute) {
        this.entryRoute = entryRoute;
    }

    public Coordinate getExitRoute() {
        return exitRoute;
    }

    public void setExitRoute(Coordinate exitRoute) {
        this.exitRoute = exitRoute;
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