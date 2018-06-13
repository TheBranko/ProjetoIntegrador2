package br.udesc.ceavi.controlller;

import br.udesc.ceavi.model.airplane.Airplane;
import br.udesc.ceavi.model.airplane.AirplaneBuilder;
import br.udesc.ceavi.model.airplane.AirplaneDirector;
import br.udesc.ceavi.model.routes.ApproachRouteBuilder;
import br.udesc.ceavi.model.routes.LandingRouteBuilder;
import br.udesc.ceavi.model.routes.Route;
import br.udesc.ceavi.model.routes.RouteBuilder;
import br.udesc.ceavi.model.routes.RouteDirector;
import br.udesc.ceavi.model.routes.WaitingRouteBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Avell
 */
public class ControllerData {

    private List<Route> approachRoutes = new ArrayList<>();
    private List<Route> waitingRoutes = new ArrayList<>();
    private List<Route> landingRoutes = new ArrayList<>();

    private AirplaneDirector airplaneDirector;
    private AirplaneBuilder airplaneBuilder;

    private RouteDirector routeDirector;
    private RouteBuilder routeBuilder;

    public ControllerData() throws IOException {
        buildApproachRoutes();
//        buildWaitingRoutes();
        buildLandingRoutes();

    }

    public Airplane buildAirplane() throws IOException, Exception {
        Random random = new Random();
        airplaneBuilder = new AirplaneBuilder();
        airplaneDirector = new AirplaneDirector(airplaneBuilder);
        
        if (airplaneBuilder.readLine()) {
            airplaneDirector.build(approachRoutes.get(random.nextInt(approachRoutes.size() - 1)));
            try {
                return airplaneBuilder.getAirplane();
            } finally {
                airplaneBuilder.startsNewAirplane();
            }
        } else {
            throw new Exception("All airplanes in the 'airplanex.txt' file have already been detected");
        }
    }
    
//    private void buildAllAirplanes() throws IOException {
//        Random random = new Random();
//        airplaneBuilder = new AirplaneBuilder();
//        airplaneDirector = new AirplaneDirector(airplaneBuilder);
//
//        while (airplaneBuilder.readLine()) {
//            airplaneDirector.build(approachRoutes.get(random.nextInt(approachRoutes.size() - 1)));
//            airplanes.add(airplaneBuilder.getAirplane());
//            airplaneBuilder.startsNewAirplane();
//        }
//    }

    private void buildApproachRoutes() throws IOException {
        routeBuilder = new ApproachRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            approachRoutes.add(routeBuilder.getRoute());
            routeBuilder.startsNewRoute();
        }
        
    }

    private void buildWaitingRoutes() throws IOException {
        routeBuilder = new WaitingRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            waitingRoutes.add(routeBuilder.getRoute());
            routeBuilder.startsNewRoute();
        }
    }

    private void buildLandingRoutes() throws IOException {
        routeBuilder = new LandingRouteBuilder();
        routeDirector = new RouteDirector(routeBuilder);

        while (routeBuilder.readLine()) {
            routeDirector.build();
            landingRoutes.add(routeBuilder.getRoute());
            routeBuilder.startsNewRoute();
        }

    }

    private void printRoutes() {
        for (Route r : approachRoutes) {
            System.out.println(r.getEntryLocation() + " " + r.getExitLocation() + " " + r.getEntrySpeed() + " " + r.getExitSpeed());
        }
    }

    public Route getLandingRoute() {
        return landingRoutes.get(0);
    } 
   

}
