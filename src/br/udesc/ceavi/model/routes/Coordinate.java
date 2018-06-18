package br.udesc.ceavi.model.routes;

/**
 * @author Felipe Lana, Kevin Kons, Lucas Adriano, Jéssica
 */
public class Coordinate {
 
    private double latitude;
    private double longitude;

    public Coordinate(double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return longitude + "," + latitude;
    }
    
    
}